package com.hello_event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HelloEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloEventApplication.class, args);
	}

}
