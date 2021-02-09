package com.banking.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.system.entity.Employee;
import com.banking.system.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public Employee saveEmployee(Employee employee) {
		employee = employeeRepository.save(employee);
		return employee;
	}
	
	public List<Employee> getAll() {
		List<Employee> employeeList = employeeRepository.findAll();
		return employeeList;
	}
	

	public Employee getEmployeeById(int id) {
		Employee employee = employeeRepository.getOne(id);
		return employee;
	}
	
	public void deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		
	}
	
	public Employee validateEmployee(String email, String password) {
		return employeeRepository.validateEmployee(email, password);
	}

}
