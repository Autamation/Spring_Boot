package com.dalrada.user.integration.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dalrada.user.integration.entity.UserEntity;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<UserEntity, Long>{
	
	
	  
//
//	@Query(value="UPDATE  myuser SET myuser.userName = :userName , myuser.userEmail=:userEmail , "
//			+ "myuser.userPassword =:userPassword , myuser.status =:status , myuser.createdBy =:createdBy"
//			+ " WHERE  myuser.id =:userId")
//	public void updateUser(@Param(value = "userName") String userName ,
//	@Param(value = "userEmail") String userEmail ,
//	@Param(value = "status") Integer status ,
//	@Param(value = "createdBy") String createdBy,
//	@Param(value = "userId")String userId
//	);
//	
	
}
