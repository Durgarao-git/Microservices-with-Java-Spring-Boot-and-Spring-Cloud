package com.microservices.cloud.student_service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}

	@Value("${address.service.url}")
	private String addressServiceUrl;

	@Bean
	ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Bean
	WebClient webClient(){
		WebClient webClient=WebClient.builder().baseUrl(addressServiceUrl).build();

		return webClient;
	}

}
