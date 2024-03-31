package com.springbootrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springbootrestapi.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
