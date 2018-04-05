package com.example;

import org.axonframework.config.EventHandlingConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Axon1Application {

	public static void main(String[] args) {
		SpringApplication.run(Axon1Application.class, args);
	}

	@Autowired
	public void configure(EventHandlingConfiguration config) {
		config.registerTrackingProcessor("accountBalance");
	}
}
