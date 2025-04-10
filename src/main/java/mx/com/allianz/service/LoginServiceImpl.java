package mx.com.allianz.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import mx.com.allianz.cipher.service.Crypt;
import mx.com.allianz.cipher.service.CryptResponse;
import mx.com.allianz.client.SoapClient;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.ApiImagenesResponse;
import mx.com.allianz.commons.model.ApiResponse;
import mx.com.allianz.commons.model.ResponseImagenModel;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.commons.model.RespuestaGenericaLogin;
import mx.com.allianz.config.RolesConfiguration;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.login.service.LoginResponseDto;
import mx.com.allianz.login.service.LoginService;
import mx.com.allianz.model.AccesoPortalRequest;
import mx.com.allianz.model.LoginRequestModel;
import mx.com.allianz.recupera.password.service.RecuperarContrasena;
import mx.com.allianz.recupera.password.service.RecuperarContrasenaResponseDto;

@Service
public class LoginServiceImpl implements ILoginService {

	private static final Logger log = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	private SoapClient soapCliente;

	@Autowired
	private ServicesConfiguration servicesConfiguration;

	@Autowired
	private RolesConfiguration rolesConfiguration;

	@Autowired
	private HttpSession session;

	/**
	 * Instancia de manejo de codigos de respuesta
	 */
	@Autowired
	private Codes codes;

	private final RestTemplate restTemplate;

	public LoginServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public RespuestaGenerica iniciarSesion(LoginRequestModel request, HttpServletRequest httpServletRequest)
			throws BusinessException {
		RespuestaGenerica response = new RespuestaGenerica();
		try {
			log.info("Metodo iniciarSesion ==> LoginServiceImpl ");
			LoginService loginRequest = new LoginService();
			loginRequest.setUsuario(request.getUsuario().toLowerCase());
			loginRequest.setPassword(request.getPassword());
			loginRequest.setTipoUsr("");

			LoginResponseDto inicarSesion = soapCliente.inicarSesion(loginRequest);
			log.info("response {}", inicarSesion.toString());

			if (!inicarSesion.isResponse()) {
				response.setEstatus(1);
				response.setMensaje(
						"No se pudo autenticar el usuario. El usuario proporcionado no existe en el sistema.");
				return response;
			}
			// Llamar al servicio REST para consultar el usuario
			String usuario = request.getUsuario().toLowerCase();
			ApiResponse consultarUsuarioResponse = consultarUsuario(usuario);

			// Verificar si se obtuvo información del usuario
			if (consultarUsuarioResponse != null && consultarUsuarioResponse.getResponse() != null
					&& consultarUsuarioResponse.getResponse().getUsuario() != null) {
				ApiResponse.ResponseData responseData = consultarUsuarioResponse.getResponse();
				// Aquí puedes procesar los datos que vienen en la respuesta
				log.info("Información del usuario consultada: " + responseData.getUsuario());
				if (responseData.getNumIntentos() >= 3) {
					response.setEstatus(4);
					response.setMensaje("El usuario esta bloqueado, favor de consultar al administrador");
					return response;
				} else {
					if (responseData.getNumIntentos() <= 2 && responseData.getIdImagen() != null) {
						// registarr en bitacora FGGG
						return getImagenes(responseData.getIdImagen());
					} else {
						response.setEstatus(2);
						response.setMensaje("Ocurrio un error al consultar la Imagen.");
						return response;
					}
				}
			} else {
				return consultarAllImagenes();
			}
		} catch (Exception e) {
			log.error("Error en conectar con el servicio de loginService {}", e);
			throw new BusinessException(codes.getResponseCode("IGBL001"));
		}
	}

	private RespuestaGenerica consultarAllImagenes() {
		log.info("Metodo consultarAllImagenes");
		RespuestaGenerica respuesta = new RespuestaGenerica();
		try {
			ApiImagenesResponse response = consultarImagenes();

			// Check if response is valid
			if (response != null && response.getResponseCode() != null
					&& "IGBL000".equals(response.getResponseCode().getCode())) {
				if (!response.getResponse().isEmpty()) {

					List<ResponseImagenModel> allImages = response.getResponse(); // List of images
					Set<String> uniqueImages = new HashSet<>(); // Set to keep track of unique image IDs
					List<Map<String, String>> selectedImages = new ArrayList<>(); // Lista para almacenar las imágenes
																					// seleccionadas
					Random random = new Random();

					// Seleccionar hasta 18 imágenes únicas
					while (selectedImages.size() < 18 && selectedImages.size() < allImages.size()) {
						int randomIndex = random.nextInt(allImages.size()); // Índice aleatorio
						ResponseImagenModel image = allImages.get(randomIndex); // Obtener la imagen

						// Asegurarse de que la imagen no haya sido seleccionada previamente
						String imageId = image.getIdImagen(); // Obtener el ID de la imagen
						if (imageId != null && !uniqueImages.contains(imageId)) {
							uniqueImages.add(imageId); // Agregar el ID a la lista de IDs únicos

							// Convertir la imagen a base64 si es un array de bytes
							byte[] imageBytes = image.getImagen(); // Suponiendo que 'getImagen()' devuelve un byte[]
							String base64Image = Base64.getEncoder().encodeToString(imageBytes); // Convertir a base64

							// Convertir la imagen a base64 y almacenarla en un Map<String, String>
							Map<String, String> imageMap = new HashMap<>();
							imageMap.put("url", "data:image/jpg;base64," + base64Image);
							imageMap.put("idImagen", imageId);
							selectedImages.add(imageMap); // Añadir la imagen seleccionada a la lista
						}
					}

					// Return only the 18 unique images
					respuesta.setEstatus(0);
					respuesta.setFlujo("2");
					respuesta.setImg(selectedImages);
					return respuesta; // Return the final object containing only the 18 images
				} else {
					log.warn("No se encontró información del usuario.");
					return null;
				}
			} else {
				log.error("Error en la respuesta del servicio: {}", response.getResponseCode().getMessage());
				return null;
			}
		} catch (Exception e) {
			log.error("Error al consultar las imágenes: ", e);
			return null;
		}
	}

	private RespuestaGenerica getImagenes(String idImagen) {
		RespuestaGenerica respuesta = new RespuestaGenerica();
		try {
			ApiImagenesResponse response = consultarImagenes();

			if (response != null && response.getResponseCode() != null
					&& "IGBL000".equals(response.getResponseCode().getCode())) {

				List<ResponseImagenModel> allImages = response.getResponse(); // List of all images
				List<Map<String, String>> selectedImages = new ArrayList<>(); // List to store selected image objects
				List<ResponseImagenModel> randomImages = new ArrayList<>(); // List to store 8 random images
				Random random = new Random();

				// Select 8 random images
				while (randomImages.size() < 8) {
					int randomIndex = random.nextInt(allImages.size());
					ResponseImagenModel image = allImages.get(randomIndex);

					// Avoid duplicates
					if (!randomImages.contains(image)) {
						randomImages.add(image);
					}
				}

				// Remove the image with the specified idImagen, if it's already in the random
				// selection
				randomImages.removeIf(image -> image.getIdImagen().equals(idImagen));

				// Now, find the image with the specified idImagen and add it as the 9th image
				ResponseImagenModel specialImage = null;
				for (ResponseImagenModel imageData : allImages) {
					if (idImagen.equals(imageData.getIdImagen())) {
						specialImage = imageData;
						break;
					}
				}

				// If the image with the specified idImagen exists, add it as the 9th image
				if (specialImage != null) {
					randomImages.add(specialImage);
				}

				// Convert all the images to base64 URLs and add them to selectedImages
				for (ResponseImagenModel imageData : randomImages) {
					byte[] imageBytes = imageData.getImagen(); // Suponiendo que 'getImagen()' devuelve un byte[]
					String base64Image = Base64.getEncoder().encodeToString(imageBytes); // Convertir a base64
					Map<String, String> imageMap = new HashMap<>();
					imageMap.put("url", "data:image/jpg;base64," + base64Image);
					imageMap.put("idImagen", imageData.getIdImagen());
					selectedImages.add(imageMap);
				}

				// Set the response object with the selected images
				respuesta.setEstatus(0);
				respuesta.setFlujo("1");
				respuesta.setImg(selectedImages);
				return respuesta; // Return the selected images list

			} else {
				log.error("Error in API response: {}", response.getResponseCode().getMessage());
				return null;
			}
		} catch (Exception e) {
			log.error("Error processing images: ", e);
			return null;
		}
	}

	private ApiImagenesResponse consultarImagenes() {
		log.info("Metodo consultarImagenes");
		try {
			String urlConsultarAllImagenes = servicesConfiguration.getUrlConsultarAllImagenes();
			log.info("Endpoint Service --> {}", urlConsultarAllImagenes);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> requestEntity = new HttpEntity<>(headers);

			ResponseEntity<ApiImagenesResponse> response = this.restTemplate.exchange(urlConsultarAllImagenes,
					HttpMethod.GET, requestEntity, ApiImagenesResponse.class);

			// Log the response to see the full list of images
			log.info("Response received: {}", response);
			ApiImagenesResponse respuesta = new ApiImagenesResponse();
			respuesta.setOk(response.getBody().isOk());
			respuesta.setResponse(response.getBody().getResponse());
			respuesta.setResponseCode(response.getBody().getResponseCode());
			respuesta.setValidations(response.getBody().getValidations());

			// Return the full response
			return respuesta;
		} catch (Exception e) {
			log.error("Error al consultar las imágenes: ", e);
			return null;
		}
	}

	public ApiResponse consultarUsuario(String usuario) {
		try {
			String urlConsultarUsuarioBitacora = servicesConfiguration.getUrlConsultarUsuarioBitacora();
			// Crear la URL con el parámetro usuario
			String url = urlConsultarUsuarioBitacora + usuario;
			log.info("Endpoint Service --> {}", url);

			// Realizar la solicitud GET y mapear la respuesta al tipo ApiResponse
			ApiResponse response = restTemplate.getForObject(url, ApiResponse.class);

			// Verificar si la respuesta contiene datos
			if (response != null && response.getResponse() != null) {
				log.info("Respuesta del servicio REST: " + response.getResponse().getUsuario());
				// Retornar la respuesta del servicio
				return response;
			} else {
				log.info("No se encontró información para el usuario.");
				return null;
			}

		} catch (Exception e) {
			log.error("Error al consultar el usuario: ", e);
			return null;
		}
	}

	@Override
	public RespuestaGenerica recuperarContrasena(RecuperarContrasena request) throws BusinessException {
		// Llamar al cliente SOAP para obtener la respuesta
		RecuperarContrasenaResponseDto recuperaContrasena = soapCliente.recuperaContrasena(request);

		// Log de la respuesta DTO
		log.info("Dto {}", recuperaContrasena);

		// Crear la respuesta genérica
		RespuestaGenerica respuesta = new RespuestaGenerica();

		// Configurar el estatus y mensaje basado en la respuesta
		int estatus = recuperaContrasena.isResponse() ? 0 : 1;
		respuesta.setEstatus(estatus);
		respuesta.setMensaje(recuperaContrasena.getMensaje());
		respuesta.setRespuesta(recuperaContrasena.toString());

		// Retornar la respuesta generada
		return respuesta;
	}

	@Override
	public RespuestaGenericaLogin accesoPortal(AccesoPortalRequest request) throws BusinessException {
		String id = "", rol = "";
		CryptResponse urlEncript = new CryptResponse();
		RespuestaGenericaLogin respuesta = new RespuestaGenericaLogin();
		String[] vector = request.getMensajeAutenticacion().split("\\|");

		if (vector != null && vector.length > 1) {
			rol = vector[2];
			if (rol != null) {
				if (rol.equalsIgnoreCase(rolesConfiguration.getClienteTipo())) {
					id = vector[4];
					if (id.equalsIgnoreCase("ul")) {
						log.info("El usuario tiene UL en la ultima posición del login, se obtiene ID de la posición 1 "
								+ vector[1]);
						id = vector[1]; // "CLE00000000000000001";
					}
				} else {
					id = vector[1];
				}
			}

			String idUsuario = request.getUsuario();
			String origenPeticion = "CLIENTE";
			String idSession = obtenerIdSesion();
			Crypt encryp= new Crypt();
			String format = String.format(servicesConfiguration.getPortalUrlParametros(), id, rol,
					idSession, idUsuario, origenPeticion);
			encryp.setInPlainText(format);
			urlEncript = soapCliente.getEncrypt(encryp);
			
			respuesta.setEncrypt(urlEncript.getOutCrypText());
			respuesta.setEstatus(0);
			respuesta.setRol(rol);
		}
		return respuesta;
	}
	
	private String obtenerIdSesion() {
        return session.getId();
    }

}
