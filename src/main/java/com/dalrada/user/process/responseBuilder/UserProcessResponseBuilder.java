package com.dalrada.user.process.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.process.beans.ProcessResponseBody;
import com.dalrada.user.process.beans.UserProcessResponse;


@Component
public class UserProcessResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserProcessResponseBuilder.class);
	public UserProcessResponse buildResponse(UserIntgResponse intgResponse) {
		logger.debug("enter into buildResponse method");
		UserProcessResponse processResponse = new UserProcessResponse();
		processResponse.setResponseCode(intgResponse.getResponseCode());
		processResponse.setResponseMsg(intgResponse.getResponseMsg());
		ProcessResponseBody responseBody = new ProcessResponseBody();
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setStatus(intgResponse.getRespBody().getStatus());
		responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
		responseBody.setUserId(intgResponse.getRespBody().getUserId());
		responseBody.setUserName(intgResponse.getRespBody().getUserName());
		responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
		processResponse.setRespBody(responseBody);
		logger.debug("enter into buildResponse method");
		return processResponse;
	}
	
	
	
	
	
	public List<UserProcessResponse> buildResponse(List<UserIntgResponse> intgRespList) {
		List<UserProcessResponse> processRespList = new ArrayList<UserProcessResponse>();
		intgRespList.forEach(intgResponse ->{
			UserProcessResponse processResponse = new UserProcessResponse();
			processResponse.setResponseCode(intgResponse.getResponseCode());
			processResponse.setResponseMsg(intgResponse.getResponseMsg());
			ProcessResponseBody responseBody = new ProcessResponseBody();
			responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(intgResponse.getRespBody().getStatus());
			responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
			responseBody.setUserId(intgResponse.getRespBody().getUserId());
			responseBody.setUserName(intgResponse.getRespBody().getUserName());
			responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
			processResponse.setRespBody(responseBody);
			processRespList.add(processResponse);
		});
		return processRespList;
	}
}
