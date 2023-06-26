package com.scw.resservice;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.scw" })
@EntityScan(basePackages = { "com.scw" })
@ComponentScan(basePackages = { "com.scw" })

public class ResServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ResServiceApplication.class, args);
	}
	
	

}
