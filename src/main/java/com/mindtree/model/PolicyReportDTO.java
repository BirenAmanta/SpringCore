package com.mindtree.model;


public class PolicyReportDTO {
	
	private String policyNumber;
	private String policyHolderName;
	private double policyHolderAge;
	private int tenureInMonths;
	
	
	@Override
	public String toString() {
		return "PolicyReportDTO [policyNumber=" + policyNumber + ", policyHolderName=" + policyHolderName
				+ ", policyHolderAge=" + policyHolderAge + ", tenureInMonths=" + tenureInMonths + "]";
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
	public double getPolicyHolderAge() {
		return policyHolderAge;
	}
	public void setPolicyHolderAge(double policyHolderAge) {
		this.policyHolderAge = policyHolderAge;
	}
	public int getTenureInMonths() {
		return tenureInMonths;
	}
	public void setTenureInMonths(int tenureInMonths) {
		this.tenureInMonths = tenureInMonths;
	}

}
