package com.excelr.ems_backend.helperClasses;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable

public class PermanentAddress {
	
	@NotNull(message = "City name should is required")
	private String perm_city;
	
	@NotNull(message = "Permanent Address line1 is required")
	private String perm_line1;
	
	@NotNull(message = "Permanent Address line2 is required")
	private String perm_line2;
	
	@Min(value = 100000, message = "PinCode Must be a six-digit number.")
    @Max(value = 999999, message = "PinCode Must be a six-digit number.")
    @Digits(integer = 6, fraction = 0, message = "PinCode Must be a six-digit number.")
	private int perm_pincode;

	public String getPerm_city() {
		return perm_city;
	}

	public void setPerm_city(String perm_city) {
		this.perm_city = perm_city;
	}

	public String getPerm_line1() {
		return perm_line1;
	}

	public void setPerm_line1(String perm_line1) {
		this.perm_line1 = perm_line1;
	}

	public String getPerm_line2() {
		return perm_line2;
	}

	public void setPerm_line2(String perm_line2) {
		this.perm_line2 = perm_line2;
	}

	public int getPerm_pincode() {
		return perm_pincode;
	}

	public void setPerm_pincode(int perm_pincode) {
		this.perm_pincode = perm_pincode;
	}

	@Override
	public String toString() {
		return "PermanentAddress [perm_city=" + perm_city + ", perm_line1=" + perm_line1 + ", perm_line2=" + perm_line2
				+ ", perm_pincode=" + perm_pincode + "]";
	}

	public PermanentAddress() {
		super();
	}

}
