package com.transfert.wari;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class WariApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args){

		SpringApplication.run(WariApplication.class, args);
	}


	@Autowired
	PasswordEncoder encoder	;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(encoder.encode("123456"));
	}
}