package com.jp.audiences.infrastructure.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.jp.audiences")

public class AudiencesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AudiencesServiceApplication.class, args);
	}

}
