package com.scw.module.auth;

public class AuthTokenString {

	private String id;
	private String appToken;
	private String employeeId;
	private String dateTime;
	private String applicationCode;
	private String authUserId;
	private String tokenValidityDt;
	private String lastLoggedDt;
	private String duration;
	public AuthTokenString() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AuthTokenString(String id, String appToken, String employeeId, String dateTime, String applicationCode,
			String authUserId, String tokenValidityDt, String lastLoggedDt, String duration) {
		super();
		this.id = id;
		this.appToken = appToken;
		this.employeeId = employeeId;
		this.dateTime = dateTime;
		this.applicationCode = applicationCode;
		this.authUserId = authUserId;
		this.tokenValidityDt = tokenValidityDt;
		this.lastLoggedDt = lastLoggedDt;
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "AuthTokenString [id=" + id + ", appToken=" + appToken + ", employeeId=" + employeeId + ", dateTime="
				+ dateTime + ", applicationCode=" + applicationCode + ", authUserId=" + authUserId
				+ ", tokenValidityDt=" + tokenValidityDt + ", lastLoggedDt=" + lastLoggedDt + ", duration=" + duration
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAppToken() {
		return appToken;
	}
	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getApplicationCode() {
		return applicationCode;
	}
	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}
	public String getAuthUserId() {
		return authUserId;
	}
	public void setAuthUserId(String authUserId) {
		this.authUserId = authUserId;
	}
	public String getTokenValidityDt() {
		return tokenValidityDt;
	}
	public void setTokenValidityDt(String tokenValidityDt) {
		this.tokenValidityDt = tokenValidityDt;
	}
	public String getLastLoggedDt() {
		return lastLoggedDt;
	}
	public void setLastLoggedDt(String lastLoggedDt) {
		this.lastLoggedDt = lastLoggedDt;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
}