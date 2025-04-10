package mx.com.allianz.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.commons.model.RespuestaGenericaLogin;
import mx.com.allianz.commons.model.SingleResponse;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.AccesoPortalRequest;
import mx.com.allianz.model.LoginRequestModel;
import mx.com.allianz.recupera.password.service.RecuperarContrasena;
import mx.com.allianz.service.ILoginService;

@RestController
@RequestMapping("/v1")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Instancia de manejo de codigos de respuesta
	 */
	@Autowired
	private Codes codes;

	/**
	 * Clave de operacion exitosa
	 */
	private static final String IGBL000 = "IGBL000";

	@Autowired
	private ILoginService loginService;

	/**
	 * Servicio encargado de realizar el login a la url de loginService
	 * 
	 * @return ResponseEntity<SingleResponse<LoginServiceResponse>> - respuesta del
	 *         servicio de loginService
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(path = "/login")
	public ResponseEntity<SingleResponse<RespuestaGenerica>> iniciarSesion(@RequestBody LoginRequestModel request,
			HttpServletRequest httpServletRequest) {
		LOGGER.info("Inicia controller ==> LoginController ==> inciarSesion usuario {}", request.getUsuario());
		SingleResponse<RespuestaGenerica> response = new SingleResponse<>();
		try {
			RespuestaGenerica responseModel = loginService.iniciarSesion(request, httpServletRequest);
			response.done(responseModel, codes.getResponseCode(IGBL000));
		} catch (BusinessException e) {
			LOGGER.error("Error de negocio ==> BusinessException: ", e);
			response.error(e.getResponseCode(), e);
		}
		LOGGER.info("Termina controller ==> NotificacionController ==> sendUrl.");
		return ResponseEntity.ok(response);
	}

	/**
	 * Servicio encargado de realizar el login a la url de loginService
	 * 
	 * @return ResponseEntity<SingleResponse<LoginServiceResponse>> - respuesta del
	 *         servicio de loginService
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(path = "/recuperar/contrasenia")
	public ResponseEntity<SingleResponse<RespuestaGenerica>> recuperarContrasena(
			@RequestBody RecuperarContrasena request) {
		LOGGER.info("Inicia controller ==> LoginController ==> recuperarContrasena usuario {}", request.getEmail());
		SingleResponse<RespuestaGenerica> response = new SingleResponse<>();
		try {
			RespuestaGenerica responseModel = loginService.recuperarContrasena(request);
			response.done(responseModel, codes.getResponseCode(IGBL000));
		} catch (BusinessException e) {
			LOGGER.error("Error de negocio ==> BusinessException: ", e);
			response.error(e.getResponseCode(), e);
		}
		LOGGER.info("Termina controller ==> NotificacionController ==> sendUrl.");
		return ResponseEntity.ok(response);
	}

	/**
	 * Servicio encargado de realizar el login a la url de loginService
	 * 
	 * @return ResponseEntity<SingleResponse<LoginServiceResponse>> - respuesta del
	 *         servicio de loginService
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(path = "/acceso/portal")
	public ResponseEntity<SingleResponse<RespuestaGenericaLogin>> accesoPortal(
			@RequestBody AccesoPortalRequest request) {
		LOGGER.info("Inicia controller ==> LoginController ==> accesoPortal");
		SingleResponse<RespuestaGenericaLogin> response = new SingleResponse<>();
		try {
			RespuestaGenericaLogin responseModel = loginService.accesoPortal(request);
			response.done(responseModel, codes.getResponseCode(IGBL000));
		} catch (BusinessException e) {
			LOGGER.error("Error de negocio ==> BusinessException: ", e);
			response.error(e.getResponseCode(), e);
		}
		LOGGER.info("Termina controller ==> NotificacionController ==> sendUrl.");
		return ResponseEntity.ok(response);
	}

}
