package com.tcs.ins.assign.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.tcs.ins.assign.service.model.AssignResourceModel;

public interface PMSAssignService {

	AssignResourceModel getAssignProject(Long id);

	Page<AssignResourceModel> searchAssignProject(PageRequest pageRequest);

	AssignResourceModel createAssignProject(AssignResourceModel projectDetailModel);

	AssignResourceModel updateAssignProject(AssignResourceModel projectDetailModel);

	void deleteAssignProject(Long id);
}
