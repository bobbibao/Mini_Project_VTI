package com.vti.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.vti.models")
@EnableJpaRepositories("com.vti.repositories")
@ComponentScan({"com.vti.controllers", "com.vti.services.implement"})
public class MiniProjectVtiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniProjectVtiApplication.class, args);
	}

}
