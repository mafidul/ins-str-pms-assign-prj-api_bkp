package com.tcs.ins.project.client.model;

import java.time.LocalDateTime;

public class ProjectModel {
	private Long id;

	private String projectName;
	private String projectLead;
	private String customer;
	private String status;
	private String priority;
	private String percentComplete;
	private String projectSummary;
	private LocalDateTime startDate;
	private LocalDateTime endDate;

	public Long getId() {
		return id;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getProjectLead() {
		return projectLead;
	}

	public String getCustomer() {
		return customer;
	}

	public String getStatus() {
		return status;
	}

	public String getPriority() {
		return priority;
	}

	public String getPercentComplete() {
		return percentComplete;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectLead(String projectLead) {
		this.projectLead = projectLead;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public void setPercentComplete(String percentComplete) {
		this.percentComplete = percentComplete;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public LocalDateTime getEndDate() {
		return endDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}

	public String getProjectSummary() {
		return projectSummary;
	}

	public void setProjectSummary(String projectSummary) {
		this.projectSummary = projectSummary;
	}

	@Override
	public String toString() {
		return "ProjectDetailModel [id=" + id + ", projectName=" + projectName + ", projectLead=" + projectLead
				+ ", customer=" + customer + ", status=" + status + ", priority=" + priority + ", percentComplete="
				+ percentComplete + ", projectSummary=" + projectSummary + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}
}
