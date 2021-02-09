package com.banking.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.banking.system.entity.Employee;
import com.banking.system.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(path="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveEmployee(@RequestBody Employee employee){
		employee=employeeService.saveEmployee(employee);
		return new ResponseEntity<>(employee,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllEmployee(){
		List<Employee> employeeList = employeeService.getAll();
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/delete",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> deleteEmployee(@RequestParam (name="id") int id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

	@RequestMapping(path="/getById",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getEmployeeById(@RequestParam (name="id") int id){
		Employee acc= employeeService.getEmployeeById(id);
		return new ResponseEntity<>(acc, HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/validate",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> validateEmployee(@RequestBody Employee empVO){
		Employee employee = employeeService.validateEmployee(empVO.getEmail(), empVO.getPassword());
		if(employee==null)
		{
			return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);				
		}	

		return new ResponseEntity<>(employee, HttpStatus.OK);	
	}
	
}
