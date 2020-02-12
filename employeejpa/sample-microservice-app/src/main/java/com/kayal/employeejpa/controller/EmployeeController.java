package com.kayal.employeejpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kayal.employeejpa.model.Employee;
import com.kayal.employeejpa.service.EmployeeService;

@RestController
@RequestMapping("/employee_service")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employee/{employeeId}")
	public Optional<Employee> getEmployee(@PathVariable(value = "employeeId") Integer id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/employee/{employeeId}")
	public Employee updateEmployeeRecord(@RequestBody Employee employee, @PathVariable("employeeId") Integer id) {
		return employeeService.updateEmployee(employee, id);
	}

	@DeleteMapping("/employee/{employeeId}")
	public void removeEmployeeRecord(@PathVariable(value = "employeeId") Integer id) {
		employeeService.deleteEmployee(id);
	}
}
