package com.example.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BankappApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BankappApplication.class, args);
	}

}
