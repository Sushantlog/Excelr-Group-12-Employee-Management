package com.excelr.ems_backend.models;

import java.util.Date;

import com.excelr.ems_backend.helperClasses.CurrentAddress;
import com.excelr.ems_backend.helperClasses.PermanentAddress;
import com.excelr.ems_backend.validators.Phone;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity

public class PersonalDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull(message = "Full name should be valid.")
	private String fullName;
	
	@NotNull(message = "Date of birth should be valid.")
	private Date dob;
	
	@NotNull(message = "Gender should not be null.")
	private String Gender;
	
	@Min(value = 0, message = "Age must be a positive number.")
	@Max(value = 999, message = "Age should be a three-digit positive number.")
	private int age;
	
	@Embedded
	@Valid
	private PermanentAddress permanentAddress;
	
	@Embedded
	@Valid
	private CurrentAddress currentAddress;
	
	@Phone(message = "Phone number must be 10 digits.")
	private String mobile;
	
	@Email(message = "Provide valid email address.")
	private String personalMail;
	
	@NotNull(message = "Provide valid name")
	private String emergencyContactName;
	
	@Phone(message = "Phone number must be 10 digits.")
	private String emergencyContact;

	@OneToOne(mappedBy = "personalDetails")
	@JsonBackReference
	private EmployeeRecord employee;

	public Long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public PermanentAddress getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(PermanentAddress permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public CurrentAddress getCurrentAddress() {
		return currentAddress;
	}

	public void setCurrentAddress(CurrentAddress currentAddress) {
		this.currentAddress = currentAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getEmergencyContactName() {
		return emergencyContactName;
	}

	public void setEmergencyContactName(String emergencyContactName) {
		this.emergencyContactName = emergencyContactName;
	}

	public String getEmergencyContact() {
		return emergencyContact;
	}

	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}

	public EmployeeRecord getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeRecord employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "PersonalDetails [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", Gender=" + Gender + ", age="
				+ age + ", mobile="
				+ mobile + ", personalMail=" + personalMail + ", emergencyContactName=" + emergencyContactName
				+ ", emergencyContact=" + emergencyContact + "]";
	}

	public PersonalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

}
