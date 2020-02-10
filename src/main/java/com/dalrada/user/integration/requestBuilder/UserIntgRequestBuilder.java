package com.dalrada.user.integration.requestBuilder;

import java.sql.Date;
import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.integration.entity.UserEntity;

@Component
public class UserIntgRequestBuilder {
	private static final Logger logger = LoggerFactory.getLogger(UserIntgRequestBuilder.class);
	public UserEntity buildRequest(UserIntgRequest intgRequest) {
		logger.debug("enter into buildRequest method");
		UserEntity entity  = new UserEntity();
		entity.setUserName(intgRequest.getUserName());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		entity.setUserEmail(intgRequest.getUserEmail());
		entity.setStatus(intgRequest.getStatus());
		entity.setUserPassword(intgRequest.getUserPassword());
		entity.setCreatedBy(intgRequest.getCreatedBy());
		LocalDate currentDate = LocalDate.now();
		entity.setCreatedDate(Date.valueOf(currentDate));
		logger.debug("exit from buildRequest method");
		return entity;
	}
	
	
	public UserEntity buildRequest(UserEntity entity,UserIntgRequest intgRequest) {
		logger.debug("enter into buildRequest method for edit");
		entity.setUserEmail(intgRequest.getUserEmail());
		entity.setUserPassword(intgRequest.getUserPassword());
		entity.setUserName(intgRequest.getUserName());
		logger.debug("exit from buildRequest method for edit");
		return entity;
	}

}
