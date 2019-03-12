package com.demo.mvc2.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.mvc2.Entity.Employee;

@Repository
public class EmployeeRepository {
	
	@Autowired
	SessionFactory sessionFactory;
	
	//@Autowired
	//JdbcTemplate jdbcTemplate;
	

	/*public List<Employee> getAllEmployee() {
	  List<Employee> empList = new ArrayList<>();
		empList.add(new Employee(1, "Juju", "Male"));
		empList.add(new Employee(2, "Papu", "Female"));
		empList.add(new Employee(3, "Sabari", "Male"));
		return empList;
	}*/
	
	/*public List<Employee> getAllEmployees() {
		String query = "select * from employee_tbl";
		*/
	
		/*
		List<Employee> employees = new ArrayList<Employee>();
		List emplst = jdbcTemplate.queryForList(query);
		Iterator it = emplst.iterator();
		while(it.hasNext()) {
			System.out.println("===> "+ it.next());
		}*/
		
		/*List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		  List<Map<String, Object>>
		    ===> {id=1, NAME=Juju, GENDER=Male}
			===> {id=2, NAME=Papuu, GENDER=Female}
		    ===> {id=3, NAME=sabari, GENDER=Male}
		 
		
		 for (Map row : rows) {
			Employee e = new Employee();
			e.setId((int) row.get("id"));
			e.setName((String) row.get("NAME"));
			e.setGender((String) row.get("GENDER"));
			employees.add(e);
		}*/
	//	List<Employee> empList = jdbcTemplate.query(query,new BeanPropertyRowMapper<>(Employee.class));		
	//  return empList;
	//  }
	
	/*public Employee getEmployeeById(int id) {
		String singleEmpQuery = "select * from employee_tbl where id=?";
		Employee emp = jdbcTemplate.queryForObject(singleEmpQuery, new Object[] {id}, new BeanPropertyRowMapper<>(Employee.class));
		return emp;
	}
	*/
	
	public List<Employee> getAllUserByHibernate() {
		TypedQuery<Employee> typedQuery = sessionFactory.getCurrentSession().createQuery("from Employee");
		System.out.println("Size of the Returned list:: " + typedQuery.getResultList().size());
		
		List<Employee> ee = sessionFactory.getCurrentSession().createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
		for (Employee e : ee) {
		    System.out.println(e.getId() + " ==> " + e.getName() + " ==> " + e.getGender() + " ");
		}
		return typedQuery.getResultList();
	}

	public void save(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);		
	}
}
