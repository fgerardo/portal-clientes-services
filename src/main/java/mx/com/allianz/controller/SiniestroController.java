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

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.commons.model.SingleResponse;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.UsuarioRequestModel;
import mx.com.allianz.service.ISiniestroService;

@RestController
@RequestMapping("/v1")
public class SiniestroController {
	private static final Logger LOGGER = LoggerFactory.getLogger(SiniestroController.class);

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
	private ISiniestroService siniestroService;

	/**
	 * Servicio encargado de realizar el login a la url de loginService
	 * 
	 * @return ResponseEntity<SingleResponse<LoginServiceResponse>> - respuesta del
	 *         servicio de loginService
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(path = "/consultar/estatus")
	public ResponseEntity<SingleResponse<RespuestaGenerica>> consultarEstatus(
			@RequestBody UsuarioRequestModel request) {
		LOGGER.info("Inicia controller ==> SiniestroController ==> consultarEstatus usuario {}", request.getUsuario());
		SingleResponse<RespuestaGenerica> response = new SingleResponse<>();
		try {
			RespuestaGenerica responseModel = siniestroService.consultarEstatus(request);
			response.done(responseModel, codes.getResponseCode(IGBL000));
		} catch (BusinessException e) {
			LOGGER.error("Error de negocio ==> BusinessException: ", e);
			response.error(e.getResponseCode(), e);
		}
		LOGGER.info("Termina controller ==> SiniestroController ==> consultarEstatus.");
		return ResponseEntity.ok(response);
	}
}
