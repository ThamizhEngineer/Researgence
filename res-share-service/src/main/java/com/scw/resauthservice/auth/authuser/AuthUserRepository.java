package com.scw.resauthservice.auth.authuser;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.scw.module.auth.AuthUser;

@Repository
public interface AuthUserRepository extends CrudRepository<AuthUser, Integer> {
		
	List<AuthUser> findByUserName(@RequestParam("userName") String userName);

	AuthUser findByEmailIdAndPassword(String emailId, String password);

	AuthUser findAllById(Integer id);
	
}
