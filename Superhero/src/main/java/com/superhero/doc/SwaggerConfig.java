package com.superhero.doc;

import java.util.Collections;

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

	
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.superhero.controller"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(getApiInfo());
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfo(
				"SuperHeros API DOC",
				"SuperHeros API DOC for Hiberus",
				"1.0",
				"https://www.hiberus.com/",
				new Contact("Eduardo Sánchez Buergo", "https://www.hiberus.com/", "esb3112@gmail.com"),
				"LICENSE",
				"https://www.hiberus.com/",
				Collections.emptyList()
				);
	}
	
}
