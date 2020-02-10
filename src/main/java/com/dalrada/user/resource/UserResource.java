package com.dalrada.user.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dalrada.user.integration.entity.UserEntity;
import com.dalrada.user.integration.exception.BusinessException;
import com.dalrada.user.integration.exception.SystemException;
import com.dalrada.user.integration.repository.UserRepository;
import com.dalrada.user.process.UserProcess;
import com.dalrada.user.process.beans.UserProcessRequest;
import com.dalrada.user.process.beans.UserProcessResponse;
import com.dalrada.user.resource.beans.UserResourceRequest;
import com.dalrada.user.resource.beans.UserResourceResponse;
import com.dalrada.user.resource.requestBuilder.UserResourceRequestBuilder;
import com.dalrada.user.resource.responseBuilder.UserResourceResponseBuilder;
import com.dalrada.user.resource.validator.RequestValidator;


@RestController
public class UserResource {
	
	UserResourceRequestBuilder requestBuilder;
	UserProcess process;
	UserResourceResponseBuilder responsebuilder;
	RequestValidator requestValidator ;
	private static final Logger logger = LoggerFactory.getLogger(UserResource.class);
	@Autowired
	public UserResource(UserResourceRequestBuilder requestBuilder, UserProcess process,
			UserResourceResponseBuilder responsebuilder, RequestValidator requestValidator) {
		super();
		this.requestBuilder = requestBuilder;
		this.process = process;
		this.responsebuilder = responsebuilder;
		this.requestValidator = requestValidator;
	}

	@GetMapping("getUser/{userId}")
	public UserResourceResponse getUserById(@PathVariable Long userId) throws BusinessException, SystemException {
		logger.debug("enter into getUserById method");
		requestValidator.validate(userId);
		UserProcessResponse processResponse = process.getUserById(userId);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from getUserById method");
		return resourceResponse;	
	}
	
	@GetMapping("getAllUser")
	public List<UserResourceResponse> getAllUsers() throws BusinessException, SystemException {
		logger.debug("enter into getAllUsers method");
		List<UserProcessResponse> processRespList = process.getAllUser();
		List<UserResourceResponse> resourceRespList = responsebuilder.buildResponse(processRespList);
		logger.debug("exit from getAllUsers method");
		return resourceRespList;	
	}
	@PostMapping("createUsers")
	public UserResourceResponse createUser(@RequestBody UserResourceRequest resourceRequest) throws BusinessException, SystemException {
		logger.debug("enter into createUser method");
		requestValidator.validate(resourceRequest);
		UserProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		UserProcessResponse processResponse = process.createUser(processRequest);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from createUsers method");
		return resourceResponse;	
	}
	@PostMapping("editUser")
	public UserResourceResponse editUser(@RequestBody UserResourceRequest resourceRequest) throws BusinessException, SystemException {
		logger.debug("enter into editUser method");
		requestValidator.validate(resourceRequest);
		System.out.println(resourceRequest);
		UserProcessRequest processRequest = requestBuilder.buildRequest(resourceRequest);
		UserProcessResponse processResponse = process.editUser(processRequest);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from editUser method");
		return resourceResponse;
		 
	}
	@PostMapping("changeStatus/{userId}/{status}")
	public UserResourceResponse changeStatus(@PathVariable Long userId, @PathVariable int status) throws BusinessException, SystemException {
		logger.debug("enter into changeStatus method");
		UserProcessResponse processResponse = process.changeStatus(userId,status);
		UserResourceResponse resourceResponse = responsebuilder.buildResponse(processResponse);
		logger.debug("exit from changeStatus method");
		return resourceResponse;
	}
	@GetMapping("healthStatus")
	public String getHealth() {
		return "Service is up and running";
	}

}

