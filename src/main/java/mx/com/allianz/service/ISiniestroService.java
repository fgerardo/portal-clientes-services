package mx.com.allianz.service;

import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.UsuarioRequestModel;

public interface ISiniestroService {

	RespuestaGenerica consultarEstatus(UsuarioRequestModel request)throws BusinessException;
}
