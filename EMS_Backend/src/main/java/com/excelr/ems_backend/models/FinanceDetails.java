package com.excelr.ems_backend.models;

import com.excelr.ems_backend.validators.NotNullOrBlank;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class FinanceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Size(min = 10, max = 10, message = "PAN card number should be 10 characters long.")
	private String panCard;
	
	@Pattern(regexp = "\\d{12}", message = "Aadhar card number should contain only 12 digits.")
	private String aadharCard;
	
	@Pattern(regexp = "\\d{15}", message = "Account number should contain only 15 digits.")
	private String accountNumber;
	
	@NotNullOrBlank(message = "bank name is required.")
	private String bankName;
	
	@NotNullOrBlank(message = "bank branch name is required.")
	private String branch;
	
	@NotNullOrBlank(message = "IFSC Code is required.")
	private String ifscCode;
	
	@NotNull(message = "CTC Breakup name is required.")
	private int ctcBreakup;

	@OneToOne(mappedBy = "financeDetails")
	@JsonBackReference
	private EmployeeRecord employee;

	public Long getId() {
		return id;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getAadharCard() {
		return aadharCard;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	public int getCtcBreakup() {
		return ctcBreakup;
	}

	public void setCtcBreakup(int ctcBreakup) {
		this.ctcBreakup = ctcBreakup;
	}

	public EmployeeRecord getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRecord employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "FinanceDetails [id=" + id + ", panCard=" + panCard + ", aadharCard=" + aadharCard + ", accountNumber="
				+ accountNumber + ", bankName=" + bankName + ", branch=" + branch + ", ifscCode=" + ifscCode
				+ ", ctcBreakup=" + ctcBreakup + ", employee=" + "]";
	}

	public FinanceDetails() {
		super();
	}

}
