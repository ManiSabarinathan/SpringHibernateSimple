package com.demo.mvc2.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.mvc2")
@PropertySource(value = { "classpath:application.properties" })
public class DBConfiguration {
	
	//Configure datasource bean
	//Configure jdbcTemplate with datasource as parameter
	
	@Autowired
	private Environment env;
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource = new DriverManagerDataSource();
		datasource.setDriverClassName(env.getRequiredProperty("spring.datasource.driver-class-name"));
		datasource.setUrl(env.getRequiredProperty("spring.datasource.url"));
		datasource.setUsername(env.getRequiredProperty("spring.datasource.username"));
		datasource.setPassword(env.getRequiredProperty("spring.datasource.password"));	
		return datasource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource datasource)  {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;		
	}
}