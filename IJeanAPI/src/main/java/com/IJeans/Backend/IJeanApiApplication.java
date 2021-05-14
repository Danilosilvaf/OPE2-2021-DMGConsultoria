package com.IJeans.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class IJeanApiApplication {

	@CrossOrigin(origins = "*")
	public static void main(String[] args) {
		SpringApplication.run(IJeanApiApplication.class, args);
	}

}
