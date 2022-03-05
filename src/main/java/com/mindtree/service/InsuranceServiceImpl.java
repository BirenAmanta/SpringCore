package com.mindtree.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.mindtree.exception.InsuranceException;
import com.mindtree.model.PolicyDTO;
import com.mindtree.model.PolicyReportDTO;
import com.mindtree.repository.InsuranceRepositoryImpl;
import com.mindtree.validator.Validator;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	InsuranceRepositoryImpl irl;

	@Override
	public String buyPolicy(PolicyDTO policy) throws InsuranceException {
		Validator.validate(policy);
		return irl.buyPolicy(policy);
	}

	@Override
	public long calculateAge(LocalDate dateOfBirth) {

		return LocalDate.now().compareTo(dateOfBirth);
	}

	@Override
	public List<PolicyReportDTO> getReport(String policyType) throws InsuranceException {

		List<PolicyReportDTO> data = irl.getAllPolicyDetails().stream()
				.filter(obj -> obj.getPolicyType().equals(policyType)).map((temp) -> {
					PolicyReportDTO teda = new PolicyReportDTO();
					teda.setPolicyHolderName(temp.getPolicyHolderName());
					teda.setPolicyNumber(temp.getPolicyNumber());
					teda.setPolicyHolderAge(calculateAge(temp.getDateOfBirth()));
					teda.setTenureInMonths(temp.getTenureInMonths());
					return teda;
				}).collect(Collectors.toList());
		if (data.size() == 0) {
			throw new InsuranceException("Service.NO_RECORD");
		}
		return data;
	}

}
