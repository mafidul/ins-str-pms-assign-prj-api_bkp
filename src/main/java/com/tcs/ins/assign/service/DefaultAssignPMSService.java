package com.tcs.ins.assign.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.tcs.ins.assign.exception.ApplicationException;
import com.tcs.ins.assign.repository.AssignTaskRepository;
import com.tcs.ins.assign.repository.entity.AssignResource;
import com.tcs.ins.assign.service.mapper.PMSAssignMapper;
import com.tcs.ins.assign.service.model.AssignResourceModel;
import com.tcs.ins.project.client.ProjectClient;
import com.tcs.ins.project.client.model.ProjectModel;
import com.tcs.ins.resource.client.ResourceClient;
import com.tcs.ins.resource.client.model.ResourceModel;

@Service
public class DefaultAssignPMSService implements PMSAssignService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAssignPMSService.class);

	private final AssignTaskRepository assignTaskRepository;
	private final PMSAssignMapper pMSAssignMapper;
	private final ResourceClient resourceClient;
	private final ProjectClient projectClient;

	public DefaultAssignPMSService(AssignTaskRepository assignTaskRepository, PMSAssignMapper pMSAssignMapper, ProjectClient projectClient,  ResourceClient resourceClient) {
		this.assignTaskRepository = assignTaskRepository;
		this.pMSAssignMapper = pMSAssignMapper;
		this.projectClient = projectClient;
		this.resourceClient = resourceClient;
	}

	@Override
	public AssignResourceModel getAssignProject(Long id) {
		AssignResource AssignResource = getOrThrow(id);
		return pMSAssignMapper.toModel(AssignResource);
	}

	private AssignResource getOrThrow(Long id) {
		Optional<AssignResource> OptionalAssignResource = assignTaskRepository.findById(id);
		if (!(OptionalAssignResource.isPresent())) {
			throw new IllegalArgumentException("Assign task not found");
		}
		return OptionalAssignResource.get();
	}

	@Override
	public Page<AssignResourceModel> searchAssignProject(PageRequest pageRequest) {
		Page<AssignResource> page = assignTaskRepository.findAll(pageRequest);
		List<AssignResourceModel> content = pMSAssignMapper.toModel(page);
		return new PageImpl<>(content, pageRequest, page.getTotalElements());
	}

	@Override
	public AssignResourceModel createAssignProject(AssignResourceModel assignResourceModel) {
		ProjectModel projectModel= projectClient.getProjectId(assignResourceModel.getId());
		if(projectModel==null) {
			throw ApplicationException.noRecordFound("Project Not Found, please provide valid project details");
		}
		ResourceModel resourceModel = resourceClient.getResourceById(assignResourceModel.getId());
		if(resourceModel == null) {
            throw ApplicationException.noRecordFound("Resource Not Found, please provide valid resource details");
        }
		assignResourceModel.setProjectName(projectModel.getProjectName());
		assignResourceModel.setResourceName(resourceModel.getFirstName() + " " + resourceModel.getLastName());
		assignResourceModel.setId(projectModel.getId());
		AssignResource assignResource = pMSAssignMapper.toEntity(assignResourceModel);
		AssignResource saveAssignResource = assignTaskRepository.save(assignResource);
		return pMSAssignMapper.toModel(saveAssignResource);
	}

	@Override
	public AssignResourceModel updateAssignProject(AssignResourceModel assignResourceModel) {
		AssignResource assignResource = getOrThrow(assignResourceModel.getId());
		if (StringUtils.hasText(assignResource.getProjectName())) {
			assignResource.setProjectName(assignResourceModel.getProjectName());
		}
		if (StringUtils.hasText(assignResource.getResourceName())) {
			assignResource.setResourceName(assignResourceModel.getResourceName());
		}
		if (StringUtils.hasText(assignResource.getExp())) {
			assignResource.setExp(assignResourceModel.getExp());
		}
		if (StringUtils.hasText(assignResource.getDesignation())) {
			assignResource.setDesignation(assignResourceModel.getDesignation());
		}
		if (StringUtils.hasText(assignResource.getSkillSet())) {
			assignResource.setSkillSet(assignResourceModel.getSkillSet());
		}
		if (StringUtils.hasText(assignResource.getRemarks())) {
			assignResource.setRemarks(assignResourceModel.getRemarks());
		}
		if (StringUtils.hasText(assignResource.getPerformRate())) {
			assignResource.setPerformRate(assignResourceModel.getPerformRate());
		}

		AssignResource saveAssignResource = assignTaskRepository.save(assignResource);
		return pMSAssignMapper.toModel(saveAssignResource);
	}

	@Override
	public void deleteAssignProject(Long id) {
		assignTaskRepository.deleteById(id);
	}
}
