package com.springbootrestapi.service;

import java.util.List;

import com.springbootrestapi.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee emp);
	
	List<Employee> getAllEmployee();
	
	Employee getEmployeeById(Long id);
	
	Employee updateEmployee(Employee emp, Long id);
	
	void deleteEmployee(Long id);
}
