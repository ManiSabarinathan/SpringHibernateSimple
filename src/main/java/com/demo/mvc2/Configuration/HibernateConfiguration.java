package com.demo.mvc2.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.demo.mvc2.Entity.Employee;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {
	
	@Autowired
	ApplicationContext context;
	
	
	//getSessionFactory()
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
		sessionFactory.setAnnotatedClasses(Employee.class);
		return sessionFactory;
	}
	
	
	//getTrasactionManager
	@Bean
	public HibernateTransactionManager getTrasactionManager() {
		HibernateTransactionManager tmanager = new HibernateTransactionManager();
		tmanager.setSessionFactory(getSessionFactory().getObject());
		return tmanager;
	}
}
