package com.excelr.ems_backend.helperClasses;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class CurrentAddress {
	@NotNull(message = "City name should is required")
	private String curr_city;
	
	@NotNull(message = "Current Address line1 is required")
	private String curr_line1;
	
	@NotNull(message = "Current Address line2 is required")
	private String curr_line2;
	
	@Min(value = 100000, message = "PinCode Must be a six-digit number.")
    @Max(value = 999999, message = "PinCode Must be a six-digit number.")
    @Digits(integer = 6, fraction = 0, message = "PinCode Must be a six-digit number.")
	private int curr_pincode;

	public String getCurr_city() {
		return curr_city;

	}

	public void setCurr_city(String curr_city) {
		this.curr_city = curr_city;
	}

	public String getCurr_line1() {
		return curr_line1;
	}

	public void setCurr_line1(String curr_line1) {
		this.curr_line1 = curr_line1;
	}

	public String getCurr_line2() {
		return curr_line2;
	}

	public void setCurr_line2(String curr_line2) {
		this.curr_line2 = curr_line2;
	}

	public int getCurr_pincode() {
		return curr_pincode;
	}

	public void setCurr_pincode(int curr_pincode) {
		this.curr_pincode = curr_pincode;
	}

	public CurrentAddress() {
		super();
	}

	@Override
	public String toString() {
		return "CurrentAddress [curr_city=" + curr_city + ", curr_line1=" + curr_line1 + ", curr_line2=" + curr_line2
				+ ", curr_pincode=" + curr_pincode + "]";
	}

}
