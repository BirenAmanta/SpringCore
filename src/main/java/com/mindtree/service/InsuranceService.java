package com.mindtree.service;

import java.time.LocalDate;
import java.util.List;

import com.mindtree.exception.InsuranceException;
import com.mindtree.model.PolicyDTO;
import com.mindtree.model.PolicyReportDTO;

public interface InsuranceService {
	public String buyPolicy(PolicyDTO policy) throws InsuranceException;

	public long calculateAge(LocalDate dateOfBirth) throws InsuranceException;

	public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException;
}
