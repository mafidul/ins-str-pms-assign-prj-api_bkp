package com.tcs.ins.assign.service.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import com.tcs.ins.assign.repository.entity.AssignResource;
import com.tcs.ins.assign.service.model.AssignResourceModel;

@Mapper(componentModel = "spring")
public interface PMSAssignMapper {
	AssignResourceModel toModel(AssignResource saveAssignResource);
	AssignResource toEntity(AssignResourceModel assignResourceModel);
	List<AssignResourceModel> toModel(Page<AssignResource> page);
}