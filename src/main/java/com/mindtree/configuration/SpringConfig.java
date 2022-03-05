package com.mindtree.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan(basePackages = { "com.mindtree.service", "com.mindtree.repository" })
@PropertySource("classpath:message.properties")
public class SpringConfig {
	@Autowired
	Environment env;
}
