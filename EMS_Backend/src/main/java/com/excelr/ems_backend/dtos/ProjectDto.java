package com.excelr.ems_backend.dtos;

import java.util.Date;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ProjectDto {

    @NotNull(message = "Project code is required.")
    @Min(value = 1, message = "Project code must be greater than zero.")
    private int projectCode;

    @NotNull(message = "Start date is required.")
    private Date startDate;

    @NotNull(message = "End date is required.")
    private Date endDate;

    @NotNull(message = "Client name is required.")
    private String clientName;

    @NotNull(message = "Project name is required.")
    private String projectName;

    @NotNull(message = "Manager employee code is required.")
    private String reportingManagerEmployeeCode;

    @NotNull(message = "Manager employee mail is required.")
    private String reportingManagerEmployeeMail;

    // Getters and setters

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

    @Override
    public String toString() {
        return "ProjectDto [projectCode=" + projectCode + ", startDate=" + startDate + ", endDate=" + endDate
                + ", clientName=" + clientName + ", projectName=" + projectName
                + ", reportingManagerEmployeeCode=" + reportingManagerEmployeeCode + ", reportingManagerEmployeeMail="
                + reportingManagerEmployeeMail + "]";
    }

    // Default constructor
    public ProjectDto() {
    }
}
