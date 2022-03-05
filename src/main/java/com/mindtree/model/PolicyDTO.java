package com.mindtree.model;

import java.time.LocalDate;


public class PolicyDTO {

	private String policyNumber;
	private String policyHolderName;
	private LocalDate dateOfBirth;
	private String policyName;
	private String policyType;
	private double premium;
	private int tenureInMonths;
	
	
	@Override
	public String toString() {
		return "PolicyDTO [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName + ", dateOfBirth="
				+ dateOfBirth + ", policyName=" + policyName + ", policyType=" + policyType + ", premium=" + premium
				+ ", tenureInMonths=" + tenureInMonths + "]";
	}


	public String getPolicyNumber() {
		return policyNumber;
	}


	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}


	public String getPolicyHolderName() {
		return policyHolderName;
	}


	public void setPolicyHolderName(String policyHolderName) {
		this.policyHolderName = policyHolderName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getPolicyName() {
		return policyName;
	}


	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}


	public String getPolicyType() {
		return policyType;
	}


	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}


	public double getPremium() {
		return premium;
	}


	public void setPremium(double premium) {
		this.premium = premium;
	}


	public int getTenureInMonths() {
		return tenureInMonths;
	}


	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}


	public PolicyDTO() {
		// TODO Auto-generated constructor stub
	}

}
