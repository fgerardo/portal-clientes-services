package mx.com.allianz.service;

import mx.com.allianz.commons.model.RespuestaGenerica;
import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.ParametroRequestModel;

public interface IHeaderService {

	RespuestaGenerica procesarHeader(ParametroRequestModel request) throws BusinessException;
}
