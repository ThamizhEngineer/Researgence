package com.scw.resauthservice.auth.authuser;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.scw.module.auth.AuthToken;
import com.scw.module.auth.AuthTokenString;
import com.scw.module.auth.AuthUser;
import com.scw.module.shared.common.CommonUtils;
import com.scw.module.shared.common.ResAlertException;

@Component
public class TokenServiceHelper {

	@Autowired
	AuthTokenRepository authTokenRepo;
	
	@Autowired(required=true)
	AuthUserRepository authUserRepo;
	
	@Autowired
	AuthUserService authUserService;

	@Autowired
	CommonUtils commonUtils;
	
	private static final Logger logger = LoggerFactory.getLogger(TokenServiceHelper.class);


	public LocalDateTime allotingValdity() {
		return LocalDateTime.now().plusHours(1);
	}

	public String createAuthToken(AuthUser authUser) {
		String currentToken = commonUtils.generateId();
		if (authUser.getAuthToken().size()>0) {
			for (AuthToken authToken : authUser.getAuthToken()) {
				logger.info("Deleting exixting tokens");
				int deleteCount = authUserService.deleteTokensByQuery(authToken.getId());
				logger.info(deleteCount+" rows deleted");
			}
		}
		AuthToken authtoken = new AuthToken();
		authtoken.setAppToken(currentToken);
		authtoken.setTokenValidityDt(allotingValdity());
		authtoken.setAuthUserId(authUser.getId());
		authtoken.setEmployeeId(authUser.getEmployeeId());
		authtoken.setDateTime(LocalDateTime.now());
		authTokenRepo.save(authtoken);
		return currentToken;
	}
	
	public AuthUser checkIfUserExistsInSys(String incomingUsername, String incomingPassword) {
		List<AuthUser> userList = authUserRepo.findByUserName(incomingUsername);
		if (userList.size() == 1) {
			AuthUser savedUser = userList.get(0);
			if (savedUser.getPassword().equals(incomingPassword)) {
				return savedUser;
			} else {
				return null;
			}
		} else if (userList.size() > 1) {
			throw new ResAlertException("Duplicate records");
		} else {
			throw new ResAlertException("No record found");
		}
	}
	
	public AuthUser internalValidation(AuthUser authUser) {

			LocalDateTime fromDateTime = LocalDateTime.now();
			long minutes = checkRemaniningMinutes(authUser.getAuthToken().get(0), fromDateTime);
			int minutesInt = (int) minutes;
			int hoursCal = minutesInt / 60;
			int minutesCal = minutesInt % 60;
			authUser.getAuthToken().get(0).setDuration(Integer.toString(hoursCal) + ":" + Integer.toString(minutesCal));
			if (minutes <= 0) {
				throw new ResAlertException("Token Expired..");
			} else {
				authUser.getAuthToken().get(0).setLastLoggedDt(fromDateTime);
				authTokenRepo.save(authUser.getAuthToken().get(0));
				return authUser;
			}
	}
	
	public long checkRemaniningMinutes(AuthToken authToken, LocalDateTime fromDateTime) {
		if (authToken.getTokenValidityDt() != null) {
			long minutes = fromDateTime.until(authToken.getTokenValidityDt(), ChronoUnit.MINUTES);
			return minutes;
		} else
			return 0;
	}
	
	public void validate(String appToken) {
		AuthUser savedUser = getAuthUserByToken(appToken);
		internalValidation(savedUser);
	}
	
	public AuthUser getAuthUserByToken(String appToken) {
		AuthUser au = new AuthUser();
		List<AuthTokenString> authTokens = authUserService.queryByToken(appToken);
		if (authTokens.size()>0) {
			for (AuthTokenString authToken : authTokens) {
				Optional<AuthUser> authUser = authUserRepo.findById(Integer.valueOf(authToken.getAuthUserId()));
				if (authUser.isPresent()) {
					au=authUser.get();
				} else {
					throw new ResAlertException("Valid user not record found for the current token");
				}
			}
			return au;
		} else {
			throw new ResAlertException("Not a valid token");
		}
	}

}
