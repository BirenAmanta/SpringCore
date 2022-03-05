package com.mindtree.validator;

import java.time.LocalDate;

import com.mindtree.exception.InsuranceException;
import com.mindtree.model.PolicyDTO;

public class Validator {

	public static void validate(PolicyDTO policy) throws InsuranceException {
		if (validatePolicyNumber(policy.getPolicyNumber(), policy.getPolicyType())) {
			if (validatePolicyHolderName(policy.getPolicyHolderName())) {
				if (validateDateOfBirth(policy.getDateOfBirth())) {
					if (validatePolicyName(policy.getPolicyName())) {
						if (validatePolicyType(policy.getPolicyType())) {
							if (validatePremium(policy.getPremium())) {
								if (validateTenure(policy.getTenureInMonths())) {

								} else {
									throw new InsuranceException("Validator.INVALID_TENURE");
								}
							} else {
								throw new InsuranceException("Validator.INVALID_PREMIUM");
							}
						} else {
							throw new InsuranceException("Validator.INVALID_POLICY_TYPE");
						}
					} else {
						throw new InsuranceException("Validator.INVALID_POLICY_NAME");
					}
				} else {
					throw new InsuranceException("Validator.INVALID_DOB");
				}
			} else {
				throw new InsuranceException("Validator.INVALID_HOLDER_NAME");
			}
		} else {
			throw new InsuranceException("Validator.INVALID_POLICY_NUMBER");
		}
	}

	public static Boolean validatePolicyName(String policyName) {
		if (policyName.length() != 0) {
			return policyName.replace(" ", "").matches("[a-zA-Z]+");

		}
		return false;

	}

	public static Boolean validatePolicyType(String policyType) {
		if (policyType.equals("Term Life Insurance") || policyType.equals("Whole Life Policy")
				|| policyType.equals("Endowment Plans")) {
			return true;
		}
		return false;

	}

	public static Boolean validatePremium(Double premium) {
		if (premium > 100.0)
			return true;
		return false;

	}

	public static Boolean validateTenure(Integer tenureInMonths) {
		if (tenureInMonths > 24)
			return true;
		return false;

	}

	public static Boolean validateDateOfBirth(LocalDate dateOfBirth) {
		return dateOfBirth.isBefore(LocalDate.now());

	}

	public static Boolean validatePolicyNumber(String policyNumber, String policyType) {
		String[] data = policyNumber.split("-");
		if (data[0].equals("WL")) {
			if (policyType.equals("Whole Life Policy")) {
				if (data[1].length() == 6 && data[1].matches("[0-9]+")) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		if (data[0].equals("TL")) {
			if (policyType.equals("Term Life Insurance")) {
				if (data[1].length() == 6 && data[1].matches("[0-9]+")) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		if (data[0].equals("EP")) {
			if (policyType.equals("Endowment Plans")) {
				if (data[1].length() == 6 && data[1].matches("[0-9]+")) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}

		return false;

	}

	public static Boolean validatePolicyHolderName(String policyHolderName) {
		String[] name = policyHolderName.split(" ");
		if (name.length == 1) {
			if (name[0].length() >= 3 && name[0].matches("[a-zA-z]+")) {
				return true;
			} else {
				return false;
			}
		} else if (name.length > 1) {
			boolean b = true;
			for (String temp : name) {

				if (!(temp.length() >= 1 && temp.matches("[a-zA-z]+"))) {
					b = false;
					break;
				}
			}
			return b;
		}
		return null;

	}
}
