package com.tcs.ins.project.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.ins.project.client.model.ProjectModel;

@Service
public class DefaultProjectClient implements ProjectClient {

	private final RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(DefaultProjectClient.class);

	public DefaultProjectClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Value("${app.project.url}")
	private String url;

	@Override
	public ProjectModel getProjectId(Long projectId) {
		logger.info("Url path from properties file: {}" + url + projectId);
		ProjectModel response = restTemplate.getForEntity(url + projectId, ProjectModel.class, projectId).getBody();
		return response;
	}
}
