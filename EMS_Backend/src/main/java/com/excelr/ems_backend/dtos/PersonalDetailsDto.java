package com.excelr.ems_backend.dtos;

import java.util.Date;

import com.excelr.ems_backend.helperClasses.CurrentAddress;
import com.excelr.ems_backend.helperClasses.PermanentAddress;

import jakarta.persistence.Embedded;

public class PersonalDetailsDto {

	private String fullName;

	private Date dob;

	private String Gender;

	private int age;

	@Embedded
	private PermanentAddress permanentAddress;

	@Embedded
	private CurrentAddress currentAddress;

	private String mobile;

	private String personalMail;

	private String emergencyContactName;

	private String emergencyContact;

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

	@Override
	public String toString() {
		return "PersonalDetails [ fullName=" + fullName + ", dob=" + dob + ", Gender=" + Gender + ", age=" + age
				+ ", permanentAddress=" + permanentAddress + ", currentAddress=" + currentAddress + ", mobile=" + mobile
				+ ", personalMail=" + personalMail + ", emergencyContactName=" + emergencyContactName
				+ ", emergencyContact=" + emergencyContact + "]";
	}

	public PersonalDetailsDto() {
	}

}