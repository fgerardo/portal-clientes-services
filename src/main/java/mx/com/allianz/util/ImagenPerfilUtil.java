package mx.com.allianz.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import mx.com.allianz.commons.model.SingleResponse;
import mx.com.allianz.config.ServicesConfiguration;
import mx.com.allianz.model.UsuarioRequestModel;

@Service
public class ImagenPerfilUtil {
	private static final Logger log = LoggerFactory.getLogger(ImagenPerfilUtil.class);
	@Autowired
	private ServicesConfiguration servicesConfiguration;

	private final RestTemplate restTemplate;

	public ImagenPerfilUtil(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String obtenerImagenPerfilUsuario(String usuario) {
		if (usuario != null) {
			try {
//				IMAGEN_PERFIL_USUARIO imagenUsuario = IMAGEN_PERFIL_USUARIOLocalServiceUtil.getIMAGEN_PERFIL_USUARIO(usuario.toLowerCase());
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);

				// Construir la URL con el idCliente
				String urlServicio = servicesConfiguration.getUrlConsultarImagenPerfil();
				log.info("Url Servicio --> {}", urlServicio);
				UsuarioRequestModel usuario2 = new UsuarioRequestModel();
				usuario2.setUsuario("ja_pt@hotmail.com");
//				log.info("Json {}", jsonBody);
				HttpEntity<UsuarioRequestModel> requestEntity = new HttpEntity<>(usuario2, headers);

				// Llamar al servicio y mapear la respuesta a ResponseGenerica
				ResponseEntity<SingleResponse<String>> responseEntity = restTemplate.exchange(urlServicio,
						HttpMethod.POST, requestEntity, new ParameterizedTypeReference<SingleResponse<String>>() {
						});

				// Verificar la respuesta cruda
				String rawResponse = responseEntity.getBody().toString();
				log.info("Raw Response: {}", rawResponse); // Imprimir el JSON crudo

				// Obtener el cuerpo de la respuesta
				SingleResponse<String> response = responseEntity.getBody();

				if (response != null && response.isOk()) {
					String base64Image = response.getResponse(); // ya viene como string base64
					log.info(base64Image);
					// lo puedes usar directamente, por ejemplo para un <img
					// src="data:image/jpeg;base64, ...">
					return base64Image;
				} 
			} catch (HttpClientErrorException | HttpServerErrorException e) {
				log.error("Error HTTP al consultar la imagen: {} - {}", e.getStatusCode(), e.getResponseBodyAsString());
			} catch (Exception e) {
				log.error("Error inesperado al consultar imagen de perfil", e);
			}
		}
		return "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";
		
	}
//	
//	public JSONObject cambiarImagenPerfil(String usuario, String imagen64){
//		if(usuario != null && imagen64 != null){
//			ImagenTipo imagenTipo = convertirStringABlob(imagen64);
//			if(imagenTipo != null && imagenTipo.getImagen() != null){
//				Blob imagenGuardada = insertarYRecuperarImagen(usuario,imagenTipo.getImagen());
//				if(imagenGuardada != null){
//					try{
//						byte[] datosBinariosImg = imagenGuardada.getBytes(1, (int) imagenGuardada.length());
//						byte[] imgBase64 = java.util.Base64.getEncoder().encode(datosBinariosImg);
//						String imgSeguridadUsuario64Encoded = new String(imgBase64, "UTF-8");
//						JSONObject respuesta = JSONFactoryUtil.createJSONObject();
//						respuesta.put("usuario", usuario);
//						respuesta.put("imagen", "data:image/"+imagenTipo.getTipo()+";base64," + imgSeguridadUsuario64Encoded);
//						return respuesta;
//					}catch(Exception exception){
//						log.error(exception);
//					}
//				}
//			}
//		}
//		return null;
//	}

//	private ImagenTipo convertirStringABlob(String imagen64){
//		if(imagen64 != null){
//			try {
//				String tipo = tipoImagen(imagen64);
//				String imagen64Limpia = limparCadena64(imagen64);
//				byte[] imagenCodificada = Base64.decode(imagen64Limpia);
//				Blob blob = new SerialBlob(imagenCodificada);
//				ImagenTipo imagenTipo = new ImagenTipo();
//				imagenTipo.setImagen(blob);
//				imagenTipo.setTipo(tipo);
//				return imagenTipo;
//			} catch (Exception e) {
//				log.error(e);
//				return null;
//			}
//		}
//		return null;
//	}
//	
//	private String limparCadena64(String imagen64){
//		if(imagen64 != null){
//			String limpiarImagen = new String();
//			limpiarImagen = imagen64.replace("data:image/jpg;base64,", "");
//			limpiarImagen = limpiarImagen.replace("data:image/png;base64,", "");
//			limpiarImagen = limpiarImagen.replace("data:image/jpeg;base64,", "");
//			return limpiarImagen;
//		}
//		return null;
//	}
//	
//	private Blob insertarYRecuperarImagen(String usuario, Blob imagen){
//		IMAGEN_PERFIL_USUARIO usuarioAGuardar = IMAGEN_PERFIL_USUARIOLocalServiceUtil.createIMAGEN_PERFIL_USUARIO(usuario);
//		usuarioAGuardar.setUsuario(usuario.toLowerCase());
//		usuarioAGuardar.setImagen(imagen);
//		try{
//			IMAGEN_PERFIL_USUARIOLocalServiceUtil.deleteIMAGEN_PERFIL_USUARIO(usuario);
//		}catch(Exception exception){
//			log.error(exception);
//		}
//		try{
//			IMAGEN_PERFIL_USUARIOLocalServiceUtil.addIMAGEN_PERFIL_USUARIO(usuarioAGuardar);
//			IMAGEN_PERFIL_USUARIO imagenGuardada = IMAGEN_PERFIL_USUARIOLocalServiceUtil.getIMAGEN_PERFIL_USUARIO(usuario);
//			return imagenGuardada.getImagen();
//		}
//		catch(Exception exception){
//			log.error(exception);
//		}
//		return null;
//	}
//	
//	private String tipoImagen(String imagen){
//		if(imagen != null){
//			if(imagen.contains("data:image/jpg")){
//				return "jpg";
//			}
//			if(imagen.contains("data:image/png")){
//				return "png";
//			}
//			if(imagen.contains("data:image/jpeg")){
//				return "jpeg";
//			}
//		}
//		return null;
//	}
}