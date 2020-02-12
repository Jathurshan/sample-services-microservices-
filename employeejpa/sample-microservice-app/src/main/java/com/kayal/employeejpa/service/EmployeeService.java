package com.kayal.employeejpa.service;

import java.util.List;
import java.util.Optional;

import com.kayal.employeejpa.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	List<Employee> getEmployees();

	Optional<Employee> getEmployeeById(Integer id);

	void deleteEmployee(Integer id);
	
	Employee updateEmployee(Employee employee, Integer id);
}