package com.amol.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.amol.core.*")
public class WipDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(WipDataApplication.class, args);
	}

}
