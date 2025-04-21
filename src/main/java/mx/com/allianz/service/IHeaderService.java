package mx.com.allianz.service;

import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.ResponsePolizaModel;

public interface IHeaderService {

	ResponsePolizaModel procesarHeader(ParametroRequestModel request) throws BusinessException;
}
