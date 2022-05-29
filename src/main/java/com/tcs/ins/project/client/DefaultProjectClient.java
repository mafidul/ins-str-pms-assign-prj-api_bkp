package com.tcs.ins.project.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.tcs.ins.project.client.model.ProjectModel;

import reactor.core.publisher.Mono;

@Service
public class DefaultProjectClient implements ProjectClient {

	private final RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(DefaultProjectClient.class);

	public DefaultProjectClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${app.project.url}")
	private String url;

	@Autowired
	private WebClient webClient;

	@Override
	public ProjectModel getProjectIdRestTemplae(Long projectId) {
		logger.info("Url path from properties file: {}" + url + projectId);
		ProjectModel response = restTemplate.getForEntity(url + projectId, ProjectModel.class, projectId).getBody();
		return response;
	}

	//Alternet way of Rest Template
	@Value("${app.project.url}")
	private String projectUrl;

	@Override
	public ProjectModel getProjectId(Long projectId) {
		logger.info("Url path from properties file: {}" + url + projectId);
		Mono<ProjectModel> response = webClient.get().uri(projectUrl + projectId).retrieve().bodyToMono(ProjectModel.class);
		return response.block();
	}
}
