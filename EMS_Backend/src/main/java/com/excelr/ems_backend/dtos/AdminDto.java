package com.excelr.ems_backend.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AdminDto {
	
	@NotNull(message = "Admin name is required")
	private String name;
	
	@Pattern(regexp = "\\d{6}", message = "employement code must be 6 digit number.")
	private String EmploymentCode;
	
	@Email(message = "Invalid Company email.")
	private String companyMail;
	
	@Size(min=8,max = 32,message = "password must be min 8 max 32 characters")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmploymentCode() {
		return EmploymentCode;
	}

	public void setEmploymentCode(String EmploymentCode) {
		this.EmploymentCode = EmploymentCode;
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

	public AdminDto() {
	}

	@Override
	public String toString() {
		return "Admin [ name=" + name + ", EmploymentCode=" + EmploymentCode + ", companyMail=" + companyMail
				+ ", password=" + password + "]";
	}

}