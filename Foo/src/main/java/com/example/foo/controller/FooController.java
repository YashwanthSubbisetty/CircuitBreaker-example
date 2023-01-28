package com.example.foo.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FooController {

    private static final String FOO_SERVICE = "fooService";
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/foo")
    @CircuitBreaker(name=FOO_SERVICE, fallbackMethod = "sendRequestFallback")
    public ResponseEntity<String> sendRequest(){
        String response = restTemplate.getForObject("http://localhost:8083/test", String.class);
//        String health = restTemplate.getForObject("http://localhost:8080/actuator/health", String.class);
        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    public ResponseEntity<String> sendRequestFallback(Exception e){
//    	String health = restTemplate.getForObject("http://localhost:8080/actuator/health", String.class);
        return new ResponseEntity<String>("Test service is down", HttpStatus.OK);

    }


}
