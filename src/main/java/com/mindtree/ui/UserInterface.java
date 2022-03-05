package com.mindtree.ui;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.core.env.Environment;
import com.mindtree.configuration.SpringConfig;
import com.mindtree.exception.InsuranceException;
import com.mindtree.model.*;
import com.mindtree.service.InsuranceServiceImpl;



public class UserInterface {

	static Environment ev;
	static AbstractApplicationContext aac;
	static Logger log = Logger.getLogger(UserInterface.class);

	public static void main(String[] args) {
		aac = new AnnotationConfigApplicationContext(SpringConfig.class);
		ev = aac.getEnvironment();
		buyPolicy();
		generateReport();
	}

	public static void buyPolicy() {
		PolicyDTO policy = new PolicyDTO();
		policy.setPolicyNumber("WL-553912");
		policy.setPolicyHolderName("James");
		policy.setDateOfBirth(LocalDate.of(1992, 01, 10));
		policy.setPolicyName("Retirement");
		policy.setPolicyType("Whole Life Policy");
		policy.setPremium(3500.0d);
		policy.setTenureInMonths(180);
		try {
			InsuranceServiceImpl iml = aac.getBean(InsuranceServiceImpl.class);
			String result = iml.buyPolicy(policy);
			log.info(ev.getProperty("UserInterface.SUCCESS") + result);
		} catch (InsuranceException e) {
			log.error(ev.getProperty(e.getMessage()));
		}

	}

	public static void generateReport() {
		try {
			InsuranceServiceImpl iml = aac.getBean(InsuranceServiceImpl.class);
			List<PolicyReportDTO> list = iml.getReport("Whole Life Policy");
			for (PolicyReportDTO temp : list) {
				log.info(temp);
			}
		} catch (InsuranceException e) {
			log.error(ev.getProperty(e.getMessage()));
		}
	}
}
