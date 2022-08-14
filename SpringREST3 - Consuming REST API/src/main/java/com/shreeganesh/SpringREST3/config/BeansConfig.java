package com.shreeganesh.SpringREST3.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shreeganesh")
public class BeansConfig {


	@Bean
	RestTemplate rest() {
		RestTemplate resttemplate = new RestTemplate();
		return resttemplate;
	}
	
}
