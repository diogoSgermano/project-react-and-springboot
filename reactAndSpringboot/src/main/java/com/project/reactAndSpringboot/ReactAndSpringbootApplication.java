package com.project.reactAndSpringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactAndSpringbootApplication {

	public static void main(String[] args) {

        SpringApplication.run(ReactAndSpringbootApplication.class, args);
        System.out.println("Home: http://localhost:8080/");
        System.out.println("Produtos: http://localhost:8080/api/produtos");
	}
}
