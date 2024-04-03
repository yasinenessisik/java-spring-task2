package com.javaspringtask2.javaspringtask2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class JavaSpringTask2Application {

	public static void main(String[] args) {
		SpringApplication.run(JavaSpringTask2Application.class, args);
	}

}
