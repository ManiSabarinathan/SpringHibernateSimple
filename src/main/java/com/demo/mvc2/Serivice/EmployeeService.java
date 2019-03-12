package com.demo.mvc2.Serivice;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.mvc2.Entity.Employee;
import com.demo.mvc2.Repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;
	
	@Transactional(readOnly = true)
	public List<Employee> getAllEmployee() {
		return empRepo.getAllUserByHibernate();
	}
	 
	public Employee getEmployee(int id) {
		 return null;
		//return empRepo.getEmployeeById(id);
	}
	
	@Transactional
	public void save(Employee employee) {
		empRepo.save(employee);
	}
}
