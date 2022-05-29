package com.tcs.ins.project.client;

import com.tcs.ins.project.client.model.ProjectModel;

public interface ProjectClient {
	
	ProjectModel getProjectId(Long projectId);

	ProjectModel getProjectIdRestTemplae(Long projectId);
}
