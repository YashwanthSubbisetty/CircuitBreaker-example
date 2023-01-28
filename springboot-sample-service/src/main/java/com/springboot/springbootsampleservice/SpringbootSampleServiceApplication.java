package com.springboot.springbootsampleservice;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSampleServiceApplication {

	public static void main(String[] args) {
		SpringApplication app = 
				new SpringApplication(SpringbootSampleServiceApplication.class);
		app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8083"));
		        app.run(args);
	}

}
