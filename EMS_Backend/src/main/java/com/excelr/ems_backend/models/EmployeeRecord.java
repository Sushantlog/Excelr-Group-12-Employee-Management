package com.excelr.ems_backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity

public class EmployeeRecord {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String employmentCode;
	private String companyMail;
	private String password;
	private String role;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
    private PersonalDetails personalDetails;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private ProfessionalDetails professionalDetails;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER,orphanRemoval = true)
	@JsonManagedReference
	private List<ProjectDetails> projects;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private FinanceDetails financeDetails;

	
	
	public EmployeeRecord() {
		super();
	}

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public PersonalDetails getPersonalDetails() {
		return personalDetails;
	}

	public void setPersonalDetails(PersonalDetails personalDetails) {
		this.personalDetails = personalDetails;
	}

	public ProfessionalDetails getProfessionalDetails() {
		return professionalDetails;
	}

	public void setProfessionalDetails(ProfessionalDetails professionalDetails) {
		this.professionalDetails = professionalDetails;
	}

	public List<ProjectDetails> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectDetails> projects) {
		this.projects = projects;
	}

	public FinanceDetails getFinanceDetails() {
		return financeDetails;
	}

	public void setFinanceDetails(FinanceDetails financeDetails) {
		this.financeDetails = financeDetails;
	}

	@Override
	public String toString() {
		return "EmployeeRecord [id=" + id + ", employmentCode=" + employmentCode + ", companyMail=" + companyMail
				+ ", password=" + password + ", role=" + role+"]";
	}
	
	
}
