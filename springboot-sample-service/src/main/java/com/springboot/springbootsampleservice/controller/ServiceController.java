package com.springboot.springbootsampleservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {
	
	@GetMapping("/test")
	public String testService() {
		
		return "Test Service is UP.";
	}

}
