package com.codingexercise.state.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RecipeRestTemplate {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
