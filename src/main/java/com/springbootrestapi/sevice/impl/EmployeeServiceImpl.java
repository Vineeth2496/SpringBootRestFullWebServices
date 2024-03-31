package com.springbootrestapi.sevice.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springbootrestapi.execption.ResourceNotFoundException;
import com.springbootrestapi.model.Employee;
import com.springbootrestapi.repository.EmployeeRepository;
import com.springbootrestapi.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository emprepo;
	
	
	public EmployeeServiceImpl(EmployeeRepository emprepo) {
		super();
		this.emprepo = emprepo;
	}


	@Override
	public Employee saveEmployee(Employee emp) {
		return emprepo.save(emp);
	}


	@Override
	public List<Employee> getAllEmployee() {

		return emprepo.findAll();
	}


	@Override
	public Employee getEmployeeById(Long id) {
//		Optional<Employee> emp=emprepo.findById(id);
//		if (emp.isPresent()) {
//			return emp.get();
//		}else {
//			throw new ResourceNotFoundException("Employee", "Id", id);
//		}
		
		return emprepo.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
	}


	@Override
	public Employee updateEmployee(Employee emp, Long id) {
		//we need  check whether employee with given id is exist in DB or not
		Employee existEmp=emprepo.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		existEmp.setFirstName(emp.getFirstName());
		existEmp.setLastName(emp.getLastName());
		existEmp.setEmail(emp.getEmail());
		
		emprepo.save(existEmp);
		return existEmp;
	}


	@Override
	public void deleteEmployee(Long id) {
		//check whether a employee exist in DB or not
		emprepo.findById(id)
		.orElseThrow(()->new ResourceNotFoundException("Employee", "Id", id));
		
		emprepo.deleteById(id);
	}

}
