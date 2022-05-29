package com.tcs.ins.resource.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tcs.ins.project.client.DefaultProjectClient;
import com.tcs.ins.resource.client.model.ResourceModel;

@Service
public class DefaultResourceClient implements ResourceClient {

	private static final Logger logger = LoggerFactory.getLogger(DefaultProjectClient.class);

	private final RestTemplate restTemplate;

	public DefaultResourceClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@Value("${app.resource.url}")
	private String url;

	@Override
	public ResourceModel getResourceById(Long resourceId) {
		logger.info("Url path from properties file: {}" + url + resourceId);
		ResourceModel response = restTemplate.getForEntity(url + resourceId, ResourceModel.class, resourceId).getBody();
		return response;
	}
}
