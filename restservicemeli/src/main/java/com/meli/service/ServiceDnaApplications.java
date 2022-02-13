package com.meli.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@ComponentScan
@EnableMongoRepositories
@SpringBootApplication
public class ServiceDnaApplications {
	public static void main(String[] args) {
		SpringApplication.run(ServiceDnaApplications.class, args);
	}

}
