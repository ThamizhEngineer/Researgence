package com.scw.module.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scw.module.multitent.TenantContext;
import com.scw.module.shared.common.CommonUtils;
import com.scw.module.shared.common.ResAlertException;
import com.scw.resauthservice.auth.authuser.AuthTokenRepository;
import com.scw.resauthservice.auth.authuser.AuthUserRepository;
import com.scw.resauthservice.auth.authuser.TokenService;
import com.scw.resauthservice.auth.authuser.TokenServiceHelper;

@Component
public class AuthInterceptor implements HandlerInterceptor {

	@Autowired
	CommonUtils commonUtils;

	@Autowired
	TokenService tokenService;

	@Autowired
	AuthTokenRepository authTokenRepo;

	@Autowired
	AuthUserRepository authUserRepo;

	@Autowired
	TokenServiceHelper tokenServiceHelper;

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
//		logger.info("Post handling");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		ResAlertException exception = null;
//		long startTime = System.currentTimeMillis();
//		logger.info("Pre handling");
		try {
			String tenantID = request.getHeader("tenantID");
			TenantContext.setCurrentTenant(tenantID);
			if (skipRequestCheck(request)) {
				return true;
			}
			String authFromHeader = request.getHeader("authorization");
			if ((authFromHeader != null && !authFromHeader.isEmpty())) {
				tokenServiceHelper.validate(authFromHeader);
//				long elapsedTime = System.currentTimeMillis() - startTime;
//				logger.info("time taken - "+(elapsedTime/1000)%60);
				return true;
			} else {
				throw new ResAlertException("authorization is Mandatory");
			}
		} catch (Exception e) {
			e.printStackTrace();
			exception = new ResAlertException(e.getMessage());
			ObjectMapper mapper = new ObjectMapper();
			response.setContentType("application/json");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			response.getWriter().write(mapper.writeValueAsString(exception.getMessage()));
			return false;
		}
	}

	public boolean skipRequestCheck(HttpServletRequest request) {
		boolean skip = false;
		String uri = request.getRequestURI();
//		System.out.println(uri);
		if (request.getMethod().equalsIgnoreCase("OPTIONS")) {
			skip = true;
		} else if (uri.contains("/auth/tokens") && uri.contains("/login")) {
			skip = true;
		} else if (uri.contains("/auth/tokens") && uri.contains("/validate")) {
			skip = true;
		} else if (uri.contains("/auth/tokens") && uri.contains("/logout")) {
			skip = true;
		}
		 skip = true;
		return skip;
	}

}