package com.dalrada.user.resource.requestBuilder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.process.beans.UserProcessRequest;
import com.dalrada.user.resource.beans.UserResourceRequest;

@Component
public class UserResourceRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceRequestBuilder.class);
	public UserProcessRequest buildRequest(UserResourceRequest resourceRequest) {
		logger.debug("enter into buildRequest method");
		UserProcessRequest processRequest  = new UserProcessRequest();
		processRequest.setUserId(resourceRequest.getUserId());
		processRequest.setUserName(resourceRequest.getUserName());
		processRequest.setUserEmail(resourceRequest.getUserEmail());
		processRequest.setUserPassword(resourceRequest.getUserPassword());
		processRequest.setStatus(resourceRequest.getStatus());
		processRequest.setCreatedBy(resourceRequest.getCreatedBy());
		logger.debug("exit from buildRequest method");
		return processRequest;
	}
}
