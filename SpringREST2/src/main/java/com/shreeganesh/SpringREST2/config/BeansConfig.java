package com.shreeganesh.SpringREST2.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shreeganesh.SpringREST2")
public class BeansConfig {

	@Bean
	DataSource ds() {
		DriverManagerDataSource dsa = new DriverManagerDataSource("jdbc:mysql://database-1.cskb7zhlimj5.ap-south-1.rds.amazonaws.com/student", "rootor", "rootored");
		//DriverManagerDataSource dsa = new DriverManagerDataSource("jdbc:mysql://localhost:3306/shreeganesh", "root", "root");
		dsa.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return dsa;
	}
	
	@Bean
	JdbcTemplate temp() {
		JdbcTemplate j = new JdbcTemplate(ds());
		return j;
	}
}
