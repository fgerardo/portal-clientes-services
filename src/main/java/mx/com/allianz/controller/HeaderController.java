package mx.com.allianz.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.allianz.commons.Codes;
import mx.com.allianz.commons.model.SingleResponse;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.ResponsePolizaModel;
import mx.com.allianz.model.response.JsonParseModel;
import mx.com.allianz.service.IHeaderService;

@RestController
@RequestMapping("/v1")
public class HeaderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HeaderController.class);

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
	private IHeaderService headerService;

	/**
	 * Servicio encargado de realizar el login a la url de loginService
	 * 
	 * @return ResponseEntity<SingleResponse<LoginServiceResponse>> - respuesta del
	 *         servicio de loginService
	 * @throws IOException
	 */
	@CrossOrigin
	@PostMapping(path = "/consultar/header")
	public ResponseEntity<SingleResponse<JsonParseModel>> procesoHeader(@RequestBody ParametroRequestModel request) {
		LOGGER.info("Inicia controller ==> HeaderController ==> procesoHeader ");
		SingleResponse<JsonParseModel> response = new SingleResponse<>();
		try {
			JsonParseModel responseModel = headerService.procesarHeader(request);
			response.done(responseModel, codes.getResponseCode(IGBL000));
		} catch (BusinessException e) {
			LOGGER.error("Error de negocio ==> BusinessException: ", e);
			response.error(e.getResponseCode(), e);
		}
		LOGGER.info("Termina controller ==> HeaderController ==> procesoHeader.");
		return ResponseEntity.ok(response);
	}
	
	
}
