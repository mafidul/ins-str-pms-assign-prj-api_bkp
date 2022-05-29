package com.tcs.ins.assign.service.model;

public class AssignResourceModel {

	private Long id;
	private Long mobile;

	private String projectName;
	private String resourceName;
	private String designation;
	private String skillSet;
	private String exp;
	private String performRate;
	private String remarks;

	public Long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getDesignation() {
		return designation;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public String getExp() {
		return exp;
	}

	public String getPerformRate() {
		return performRate;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public void setPerformRate(String performRate) {
		this.performRate = performRate;
	}

	public Long getMobile() {
		return mobile;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
