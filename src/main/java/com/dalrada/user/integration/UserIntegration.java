package com.dalrada.user.integration;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dalrada.user.integration.beans.UserIntgRequest;
import com.dalrada.user.integration.beans.UserIntgResponse;
import com.dalrada.user.integration.entity.UserEntity;
import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.integration.repository.UserRepository;
import com.dalrada.user.integration.requestBuilder.UserIntgRequestBuilder;
import com.dalrada.user.integration.responseBuilder.UserIntgResponseBuilder;

@Component
public class UserIntegration {

	UserIntgRequestBuilder requestBuilder ;
	UserRepository repository ;
	UserIntgResponseBuilder responseBuilder ;
	private static final Logger logger = LoggerFactory.getLogger(UserIntegration.class);
	@Autowired
	public UserIntegration(UserIntgRequestBuilder requestBuilder, UserRepository repository,
			UserIntgResponseBuilder responseBuilder) {
		super();
		this.requestBuilder = requestBuilder;
		this.repository = repository;
		this.responseBuilder = responseBuilder;
	}

	public UserIntgResponse getUserById(Long userId) throws BusinessException, SystemException {
		logger.debug("enter into getUserById method");
		UserEntity user;
		try {
			user = repository.findById(userId).get();
		} catch (RuntimeException e) {
			logger.error("Exception occured due to " ,e);
			throw new SystemException("","");	
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from getUserById method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}

	public List<UserIntgResponse> getAllUsers() throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<UserEntity> userList;
		try {
			userList = repository.findAll();
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");	
		}
		List<UserIntgResponse> responseList = new ArrayList<UserIntgResponse>();
		if(userList != null) {
			userList.forEach(user ->{
				UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
				responseList.add(intgResponse);
			});
			logger.debug("exit from getAllUsers method");
			return responseList;
		}
		else
			throw new BusinessException("505","data not persent");
	}
	public UserIntgResponse createUser(UserIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into createUser method");
		UserEntity user = requestBuilder.buildRequest(intgRequest);
		UserEntity entity;
		try {
			entity = repository.save(user);
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		if(entity != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from getAllUsers method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not saved");
	}

	public UserIntgResponse editUser(UserIntgRequest intgRequest) throws BusinessException, SystemException {
		logger.debug("enter into editUser method");
		UserEntity user = null ;
		
		Long userId = intgRequest.getUserId();
		try {
			user = repository.findById(userId).get();
			user = requestBuilder.buildRequest(user,intgRequest);
			user = repository.save(user);
//			repository.updateUser(userEmail ,userPassword , status ,createdBy , userId );
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from editUser method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}

	public UserIntgResponse changeStatus(Long userId, int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		UserEntity user = null ;
		try {
			user = repository.findById(userId).get();
			user.setStatus(status);
			user = repository.save(user);
//			repository.updateUser(userEmail ,userPassword , status ,createdBy , userId );
		} catch (RuntimeException e) {
			logger.error("Exception occured  " ,e);
			throw new SystemException("","");
		}
		catch (Exception e) {
			throw new BusinessException("","");
		}
		if(user != null) {
			UserIntgResponse intgResponse = responseBuilder.buildResponse(user);
			logger.debug("exit from changeStatus method");
			return intgResponse;
		}
		else
			throw new BusinessException("505","data not persent");
	}
}
