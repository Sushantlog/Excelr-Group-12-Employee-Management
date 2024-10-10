package com.excelr.ems_backend.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity

public class ProjectDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int projectCode;

	private Date startDate;

	private Date endDate;

	private String clientName;

	private String projectName;

	private String reportingManagerEmployeeCode;

	private String reportingManagerEmployeeMail;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	@JsonBackReference
	private EmployeeRecord employee;

	public Long getId() {
		return id;
	}


	public int getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(int projectCode) {
		this.projectCode = projectCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getReportingManagerEmployeeCode() {
		return reportingManagerEmployeeCode;
	}

	public void setReportingManagerEmployeeCode(String reportingManagerEmployeeCode) {
		this.reportingManagerEmployeeCode = reportingManagerEmployeeCode;
	}

	public String getReportingManagerEmployeeMail() {
		return reportingManagerEmployeeMail;
	}

	public void setReportingManagerEmployeeMail(String reportingManagerEmployeeMail) {
		this.reportingManagerEmployeeMail = reportingManagerEmployeeMail;
	}

	public EmployeeRecord getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRecord employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "ProjectDetails [id=" + id + ", projectCode=" + projectCode + ", startDate=" + startDate + ", endDate="
				+ endDate + ", clientName=" + clientName + ", projectName=" + projectName
				+ ", reportingManagerEmployeeCode=" + reportingManagerEmployeeCode + ", reportingManagerEmployeeMail="
				+ reportingManagerEmployeeMail + "]";
	}


	public ProjectDetails() {
		
	}
	
	
}
