package com.excelr.ems_backend.models;

import java.util.Date;
import java.util.List;

import com.excelr.ems_backend.helperClasses.CurrentAddress;
import com.excelr.ems_backend.helperClasses.EmploymentHistory;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity

public class ProfessionalDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Pattern(regexp = "\\d{6}", message = "employement code must be 6 digit number.")
	private String employmentCode;
	
	@Email(message = "Invalid Company email.")
	private String companyMail;
	
	@Size(min = 8,max = 12,message = "Office phone must be min 8 and max 12 digits.")
	private String officePhone;

	@Embedded
	@Valid
	private CurrentAddress officeAddress;
	
	@Pattern(regexp = "\\d{6}", message = "employement code must be 6 digit number.")
	private String reportManagerEmployeeCode;

	@Email(message = "Invalid reportManagerEmployee email.")
	private String reportManagerEmployeeMail;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<EmploymentHistory> employmentHistory;
	
	@NotNull(message = "joining date is required.")
	private Date dateOfJoining;
	
	@NotNull(message = "Hr name is required.")
	private String hrName;

	@OneToOne(mappedBy = "professionalDetails")
	@JsonBackReference
	private EmployeeRecord employee;

	public Long getId() {
		return id;
	}

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

	public EmployeeRecord getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRecord employee) {
		this.employee = employee;
	}

	public ProfessionalDetails() {
		super();
	}

	@Override
	public String toString() {
		return "ProfessionalDetails [id=" + id + ", employmentCode=" + employmentCode + ", companyMail=" + companyMail
				+ ", officePhone=" + officePhone + ", reportManagerEmployeeCode="
				+ reportManagerEmployeeCode + ", reportManagerEmployeeMail=" + reportManagerEmployeeMail
				+ ", dateOfJoining=" + dateOfJoining + ", hrName=" + hrName
				+ "]";
	}

}
