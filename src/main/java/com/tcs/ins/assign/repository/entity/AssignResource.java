package com.tcs.ins.assign.repository.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.envers.Audited;

@Entity(name = "ASSIGNRESOURCE")
@Audited
public class AssignResource extends Auditable implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private Long id;

	@Column(name = "PROJECTNAME")
	private String projectName;
	@Column(name = "RESOURCENAME")
	private String resourceName;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name = "SKILLSET")
	private String skillSet;
	@Column(name = "EXP")
	private String exp;
	@Column(name = "PERFORMRATE")
	private String performRate;
	@Column(name = "MOBILE")
	private Long mobile;
	@Column(name = "REMARK")
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
