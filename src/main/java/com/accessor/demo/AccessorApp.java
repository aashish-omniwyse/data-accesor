package com.accessor.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessorApp {
	private static final Logger logger = LoggerFactory.getLogger(AccessorApp.class);

	public static void main(String[] args) {
		SpringApplication.run(AccessorApp.class, args);
		logger.info("Data Accessor application started...");
	}
}
