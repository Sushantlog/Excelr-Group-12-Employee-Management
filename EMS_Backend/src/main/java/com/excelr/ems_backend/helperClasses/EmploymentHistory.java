package com.excelr.ems_backend.helperClasses;

import java.util.Date;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;

@Embeddable
public class EmploymentHistory {
	
	@NotNull(message = "Company name is required.")
	private String companyName;
	
	@Past(message = "joining date must be past.")
	private Date joiningDate;
	
	@Past(message = "End date must be past.")
	private Date endDate;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public EmploymentHistory() {
		super();
	}

	@Override
	public String toString() {
		return "EmploymentHistory [companyName=" + companyName + ", joiningDate=" + joiningDate + ", endDate=" + endDate
				+ "]";
	}

}
