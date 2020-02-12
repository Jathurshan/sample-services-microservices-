package com.kayal.employeejpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kayal.employeejpa.model.Employee;
import com.kayal.employeejpa.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Integer id) {
		return employeeRepository.findById(id);
	}

	@Override
	public void deleteEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee updateEmployee(Employee employee, Integer id) {
		Optional<Employee> employeeEntity = employeeRepository.findById(id);
		Employee updatedEntity = new Employee();

		if (employeeEntity.isPresent()) {
			updatedEntity.setId(id);
			updatedEntity.setName(employee.getName());
			updatedEntity.setCity(employee.getCity());
			return employeeRepository.save(updatedEntity);

		}
		return null;
	}

}
