package com.tcs.ins;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class AssignProjectApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssignProjectApiApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@Value("${app.project.url}")
	private String projectUrl;

	//Alternet way of Rest Templae
	@Bean
	public WebClient webClient() {
		return WebClient.builder().baseUrl(projectUrl).build();
	}
}
