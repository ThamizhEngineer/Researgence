package com.scw.module.multitent;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class TenantProperties {

	private String tenantId;
	private String url;
	private String username;
	private String password;
	private String driverName;
}