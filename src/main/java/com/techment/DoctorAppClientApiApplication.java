package com.techment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DoctorAppClientApiApplication {

	
	//hello
	
	public static void main(String[] args) {
		SpringApplication.run(DoctorAppClientApiApplication.class, args);
	}

}
