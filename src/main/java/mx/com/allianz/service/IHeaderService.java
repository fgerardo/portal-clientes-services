package mx.com.allianz.service;

import mx.com.allianz.exception.BusinessException;
import mx.com.allianz.model.ParametroRequestModel;
import mx.com.allianz.model.response.JsonParseModel;

public interface IHeaderService {

	JsonParseModel procesarHeader(ParametroRequestModel request) throws BusinessException;
}
