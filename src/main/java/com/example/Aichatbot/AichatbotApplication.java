package com.example.Aichatbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("com.example.Aichatbot.Repository")  // ✅ Ensure correct package
public class AichatbotApplication {
	public static void main(String[] args) {
		SpringApplication.run(AichatbotApplication.class, args);


	}
}