package com.excelr.ems_backend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message = "name is required.")
	private String name;
	
	@NotNull(message = "employment code is required.")
	private String employmentCode;
	
	@NotNull(message = "mail is required.")
	private String companyMail;
	
	@NotNull(message = "password is required.")
	private String password;
	
	@NotNull(message = "role is required.")
	private String role;
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public Admin() {
	}

	@Override
	public String toString() {
		return "Admin [id=" + id + ", name=" + name + ", EmploymentCode=" + employmentCode + ", companyMail="
				+ companyMail + ", password=" + password + ", role=" + role + "]";
	}
	
	
}
