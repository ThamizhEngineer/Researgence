package com.scw.resauthservice.auth.authuser;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.scw.module.auth.AuthToken;

public interface AuthTokenRepository extends CrudRepository<AuthToken, Integer> {

	List<AuthToken> findByAppToken(String appToken);

}
