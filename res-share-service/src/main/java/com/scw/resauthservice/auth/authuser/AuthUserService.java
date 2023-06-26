package com.scw.resauthservice.auth.authuser;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.scw.module.auth.AuthTokenString;
import com.scw.module.auth.AuthUser;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@RestController
@RequestMapping(path = "auth/users")
@Component
@Service
public class AuthUserService {

	@Autowired(required=true)
	AuthUserRepository authUserRepo;

	@Autowired(required=true)
	JdbcTemplate jdbcTemplate;

	@GetMapping
	public Iterable<AuthUser> fetchAll() {
		return authUserRepo.findAll();
	}

	@GetMapping("/{id}")
	public Optional<AuthUser> fetchById(@PathVariable(value = "id") Integer id) {
		return authUserRepo.findById(id);
	}
	

	private AuthUser fetchByEmailIdAndPassword(String emailId, String password) {
		// TODO Auto-generated method stub
		return authUserRepo.findByEmailIdAndPassword(emailId,password) ;
	}

	@GetMapping("/authtoken/{token}")
	public List<AuthTokenString> fetchAuthTokenByToken(@PathVariable(value = "token") String token) {
		return queryByToken(token);
	}

	public List<AuthTokenString> queryByToken(String token) {
		String sql = "select au.id,au.app_token,au.employee_id,au.date_time,au.application_code,au.auth_user_id,au.token_validity_dt,au.last_logged_dt,au.duration from auth_token au where au.app_token='"
				+ token + "'";
		return jdbcTemplate.query(sql,
				(rs, rowNum) -> new AuthTokenString(rs.getString("id"), rs.getString("app_token"),
						rs.getString("employee_id"), rs.getString("date_time"), rs.getString("application_code"),
						rs.getString("auth_user_id"), rs.getString("token_validity_dt"), rs.getString("last_logged_dt"),
						rs.getString("duration")));
	}

	public int deleteTokensByQuery(Integer id) {
		String sql = "delete from auth_token where id='" + id + "'";
		int rows = jdbcTemplate.update(sql);
		return rows;
	}

}