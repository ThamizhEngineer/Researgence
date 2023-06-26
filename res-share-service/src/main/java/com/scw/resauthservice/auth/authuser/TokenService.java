package com.scw.resauthservice.auth.authuser;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.scw.module.auth.AuthToken;
import com.scw.module.auth.AuthUser;
import com.scw.module.multitent.TenantContext;
import com.scw.module.shared.common.ResAlertException;

@RestController
@RequestMapping("/auth/tokens")
@Service
@CrossOrigin
public class TokenService {

	@Autowired(required=true)
	AuthUserRepository authUserRepo;

	@Autowired
	AuthTokenRepository authTokenRepo;

	@Autowired
	AuthUserService authUserService;

	@Autowired
	TokenServiceHelper helper;

	private static final Logger logger = LoggerFactory.getLogger(TokenServiceHelper.class);

	@PostMapping("/login")
	public Optional<AuthUser> login(@RequestBody(required = false) AuthUser authUser,
			@RequestHeader("tenantID") String tenantID) {
		String currentToken="";
		try {
			TenantContext.setCurrentTenant(tenantID);
			authUser = helper.checkIfUserExistsInSys(authUser.getUserName(), authUser.getPassword());
			if (authUser != null) {
				currentToken = helper.createAuthToken(authUser);
				if (!currentToken.isEmpty()) {
					Optional<AuthUser> finalResponse = authUserRepo.findById(authUser.getId());
					finalResponse.get().setCurrentToken(currentToken);
					return finalResponse;
				} else {
					logger.error("Error generating token");
					throw new ResAlertException("Error generating token");
				}
			} else {
				logger.error("Invalid username/password");
				throw new ResAlertException("Invalid username/password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Invalid user");
			throw new ResAlertException("Invalid user");
		}
	}

	@PostMapping("/logout")
	public void logout(@RequestBody(required = false) AuthUser authUser) {
		logger.info("Logging out");
		try {
			if (authUser.getAuthToken() != null) {
				for (AuthToken authToken : authUser.getAuthToken()) {
					logger.info("Deleting exixting tokens");
					int deleteCount = authUserService.deleteTokensByQuery(authToken.getId());
					logger.info(deleteCount + " rows deleted");
				}
			} else {
				throw new ResAlertException("No data");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResAlertException("Error logging out");
		}
	}

	@PostMapping("/validate")
	public AuthUser validateToken(@RequestBody(required = false) AuthUser authUser) {
		return helper.internalValidation(authUser);
	}
}
