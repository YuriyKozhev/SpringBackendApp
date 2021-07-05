package com.yuriy.SpringBackendApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBackendApp {
	private static final Logger logger = LoggerFactory.getLogger(SpringBackendApp.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBackendApp.class, args);
		logger.info("Application has been started");
	}

}
