package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("model")
public class KladionicaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(KladionicaWebApplication.class, args);
	}

}
