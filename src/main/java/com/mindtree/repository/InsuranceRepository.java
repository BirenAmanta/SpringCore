package com.mindtree.repository;

import java.util.List;
import com.mindtree.exception.InsuranceException;
import com.mindtree.model.PolicyDTO;

public interface InsuranceRepository {

	public String buyPolicy(PolicyDTO policy) throws InsuranceException;

	public List<PolicyDTO> getAllPolicyDetails() throws InsuranceException;
}
