package com.dalrada.user.integration.responseBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.integration.entity.UserEntity;

@Component
public class UserIntgResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserIntgResponseBuilder.class);
	public UserIntgResponse buildResponse(UserEntity entity) {
		logger.debug("enter into buildResponse method");
		UserIntgResponse response = new UserIntgResponse();
		response.setResponseCode("200");
		response.setResponseMsg("successfull");
		response.setRespBody(entity);
		logger.debug("exit from buildResponse method");
		return response;		
	}

	public UserIntgResponse buildResponse(String responseCode, String respMsg) {
		logger.debug("enter into buildResponse method");
		UserIntgResponse response = new UserIntgResponse();
		response.setResponseCode(responseCode);
		response.setResponseMsg(respMsg);
		logger.debug("exit from buildResponse method");
		return response;	

	}

}
