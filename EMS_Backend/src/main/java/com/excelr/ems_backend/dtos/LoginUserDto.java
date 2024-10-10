package com.excelr.ems_backend.dtos;

public class LoginUserDto {
	private Long id;
	private String name;
	private String companyMail;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompanyMail() {
		return companyMail;
	}

	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}

	
	
	public LoginUserDto(Long id, String name, String companyMail) {
		this.id = id;
		this.name = name;
		this.companyMail = companyMail;
	}

	public LoginUserDto() {
	}

}
