package mx.com.allianz.service;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.commons.model.RespuestaGenericaLogin;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.AccesoPortalRequest;
import mx.com.allianz.model.LoginRequestModel;
import mx.com.allianz.recupera.password.service.RecuperarContrasena;

public interface ILoginService {

	RespuestaGenerica iniciarSesion(LoginRequestModel request, HttpServletRequest httpServletRequest)
			throws BusinessException;

	RespuestaGenerica recuperarContrasena(RecuperarContrasena request) throws BusinessException;
	
	RespuestaGenericaLogin accesoPortal(AccesoPortalRequest request) throws BusinessException;

}
