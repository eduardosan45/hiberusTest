package com.superhero;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuperheroApplication {

	private static final Logger logger = LoggerFactory.getLogger(SuperheroApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SuperheroApplication.class, args);
		logger.info("*****************************");
		logger.info("SuperHero application started");
		logger.info("*****************************");
		
	}

}
