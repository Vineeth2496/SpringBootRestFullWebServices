package com.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestapi.model.Employee;
import com.springbootrestapi.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	private EmployeeService empser;

	public EmployeeController(EmployeeService empser) {
		super();
		this.empser = empser;
	}
	
	//build create employee Rest API
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp){
		return new ResponseEntity<Employee>(empser.saveEmployee(emp), HttpStatus.CREATED);	
	}
	
	//build get all Employees Rest API
	@GetMapping
	public List<Employee> getAllEmployee(){
		return  empser.getAllEmployee();
	}
	
	//bulid get employee by id Rest API
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long empid){
		return new ResponseEntity<Employee>(empser.getEmployeeById(empid), HttpStatus.OK);
	}
	
	//build update employee Rest API
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp){
		return new ResponseEntity<Employee>(empser.updateEmployee(emp, id), HttpStatus.OK);
	}
	
	//build delete employee Rest API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		//delete employee by id
		empser.deleteEmployee(id);
		
		return new ResponseEntity<String>("Employee deleted sucessfully!. ",HttpStatus.OK);
	}
}
