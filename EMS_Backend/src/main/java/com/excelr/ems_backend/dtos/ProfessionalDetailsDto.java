package com.excelr.ems_backend.dtos;

import java.util.Date;
import java.util.List;

import com.excelr.ems_backend.helperClasses.CurrentAddress;
import com.excelr.ems_backend.helperClasses.EmploymentHistory;

public class ProfessionalDetailsDto {
    private String employmentCode;
    private String companyMail;
    private String officePhone;
    private CurrentAddress officeAddress;
    private String reportManagerEmployeeCode;
    private String reportManagerEmployeeMail;
    private List<EmploymentHistory> employmentHistory;
    private Date dateOfJoining;
    private String hrName;
	
	public String getEmploymentCode() {
		return employmentCode;
	}
	public void setEmploymentCode(String employmentCode) {
		this.employmentCode = employmentCode;
	}
	public String getCompanyMail() {
		return companyMail;
	}
	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}
	public String getOfficePhone() {
		return officePhone;
	}
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	public CurrentAddress getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(CurrentAddress officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getReportManagerEmployeeCode() {
		return reportManagerEmployeeCode;
	}
	public void setReportManagerEmployeeCode(String reportManagerEmployeeCode) {
		this.reportManagerEmployeeCode = reportManagerEmployeeCode;
	}
	public String getReportManagerEmployeeMail() {
		return reportManagerEmployeeMail;
	}
	public void setReportManagerEmployeeMail(String reportManagerEmployeeMail) {
		this.reportManagerEmployeeMail = reportManagerEmployeeMail;
	}
	public List<EmploymentHistory> getEmploymentHistory() {
		return employmentHistory;
	}
	public void setEmploymentHistory(List<EmploymentHistory> employmentHistory) {
		this.employmentHistory = employmentHistory;
	}
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getHrName() {
		return hrName;
	}
	public void setHrName(String hrName) {
		this.hrName = hrName;
	}
	public ProfessionalDetailsDto() {
		
	}
	@Override
	public String toString() {
		return "ProfessionalDTO [employmentCode=" + employmentCode + ", companyMail=" + companyMail + ", officePhone="
				+ officePhone + ", officeAddress=" + officeAddress + ", reportManagerEmployeeCode="
				+ reportManagerEmployeeCode + ", reportManagerEmployeeMail=" + reportManagerEmployeeMail
				+ ", employmentHistory=" + employmentHistory + ", dateOfJoining=" + dateOfJoining + ", hrName=" + hrName
				+ "]";
	}
	

}