package com.codingexercise.state.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	 private static final String SWAGGER_API_VERSION = "2.0";
	    private static final String LICENCE_TEXT = "Apache LICENCE 2.0";
	    private static final String TITLE = "A REST API for US States";
	    private static final String DESCRIPTION = "REST API to search for states";
	    private static final Contact CONTACT = new Contact("Eden Gebrehanna","https://www.travelport.com/","eduworku@gmail.com");
	    
	    @Bean
	    public Docket swaggerDoc() {
	    	return new Docket(DocumentationType.SWAGGER_2)
    				.select()
    				.apis(RequestHandlerSelectors.basePackage("com.codingexercise.state"))
    				.paths(PathSelectors.regex("/api.*"))
    				.build()
    				.apiInfo(metaInfo());
	    }
	    
	    private ApiInfo metaInfo() {
	    	
	    	return new ApiInfo(TITLE,DESCRIPTION,SWAGGER_API_VERSION,"Terms of Service",CONTACT,LICENCE_TEXT,"http://www.apache.org/licenses/");
	    }
}
