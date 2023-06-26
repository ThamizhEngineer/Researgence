package com.scw.module.shared.common;

import org.springframework.stereotype.Controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class CommonUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonUtils.class);


	public String generateId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}
	

}
