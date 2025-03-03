// src/main/java/com/dencofamily/popeyes/PopeyesApplication.java
package com.dencofamily.popeyes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.dencofamily.popeyes.punch")
public class PopeyesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PopeyesApplication.class, args);
	}
}
