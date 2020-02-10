package com.dalrada.user.resource.responseBuilder;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.resource.beans.ResourceResponseBody;
import com.dalrada.user.resource.beans.UserResourceResponse;

@Component
public class UserResourceResponseBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceResponseBuilder.class);
	
	public UserResourceResponse buildResponse(UserProcessResponse intgResponse) {
		logger.debug("enter into buildResponse method");
		UserResourceResponse resourceResponse = new UserResourceResponse();
		resourceResponse.setResponseCode(intgResponse.getResponseCode());
		resourceResponse.setResponseMsg(intgResponse.getResponseMsg());
		ResourceResponseBody responseBody = new ResourceResponseBody();
		responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
		responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
		responseBody.setStatus(intgResponse.getRespBody().getStatus());
		responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
		responseBody.setUserId(intgResponse.getRespBody().getUserId());
		responseBody.setUserName(intgResponse.getRespBody().getUserName());
		responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
		resourceResponse.setRespBody(responseBody);
		logger.debug("exit from buildResponse method");
		return resourceResponse;
	}
	
	public List<UserResourceResponse> buildResponse(List<UserProcessResponse> intgRespList) {
		logger.debug("enter into buildResponse method");
		List<UserResourceResponse> processRespList = new ArrayList<UserResourceResponse>();
		intgRespList.forEach(intgResponse ->{
			UserResourceResponse resourceResponse = new UserResourceResponse();
			resourceResponse.setResponseCode(intgResponse.getResponseCode());
			resourceResponse.setResponseMsg(intgResponse.getResponseMsg());
			ResourceResponseBody responseBody = new ResourceResponseBody();
			responseBody.setCreatedBy(intgResponse.getRespBody().getCreatedBy());
			responseBody.setCreatedDate(intgResponse.getRespBody().getCreatedDate());
			responseBody.setStatus(intgResponse.getRespBody().getStatus());
			responseBody.setUserEmail(intgResponse.getRespBody().getUserEmail());
			responseBody.setUserId(intgResponse.getRespBody().getUserId());
			responseBody.setUserName(intgResponse.getRespBody().getUserName());
			responseBody.setUserPassword(intgResponse.getRespBody().getUserPassword());	
			resourceResponse.setRespBody(responseBody);
			processRespList.add(resourceResponse);
		});
		logger.debug("exit from buildResponse method");
		return processRespList;
	}
	
}
