package com.scw.resauthservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.scw.module.auth.interceptor.AuthInterceptor;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.scw" })
@EntityScan(basePackages = { "com.scw" })
@ComponentScan(basePackages = { "com.scw" })
public class ResAuthServiceApplication implements WebMvcConfigurer {

	private static final String[] REQUEST_METHOD_SUPPORTED = { "GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS",
			"HEAD" };
	
	public static void main(String[] args) {
		SpringApplication.run(ResAuthServiceApplication.class, args);
	}
	
	@Bean
	 public WebMvcConfigurer corsConfigurer() {
	     return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	             registry.addMapping("/api/rest/**").allowedOrigins("*").allowedHeaders("*").allowedMethods(REQUEST_METHOD_SUPPORTED);
	         }
	     };
	 }
	
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Configuration
	public class WebMvcConfig implements WebMvcConfigurer {
		
		@Autowired
		AuthInterceptor authInterceptor;

	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        registry.addInterceptor(authInterceptor);
	    }
	}

}
