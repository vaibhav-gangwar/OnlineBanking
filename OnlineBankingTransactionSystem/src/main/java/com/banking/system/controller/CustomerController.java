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


import com.banking.system.entity.Customer;
import com.banking.system.service.CustomerService;
import com.banking.system.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	AccountService accountService;

	@RequestMapping(path="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveCustomer(@RequestBody Customer customer){
		customer=customerService.saveCustomer(customer);

//		customer=customerService.validateCustomer(customer.getEmail(), customer.getPassword());
//
//		
//		Account acc=new Account();
//		acc.setAccountNumber("RVR" + customer.getContact());
//		acc.setBalance(0);
//		acc.setCustomer(customer);
//		accountService.saveAccount(acc);
		
		return new ResponseEntity<>(customer,HttpStatus.CREATED);		
	}
	
	@RequestMapping(path="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllCustomer(){
		List<Customer> customerList = customerService.getAll();
		return new ResponseEntity<>(customerList,HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/getallemail",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllEmail(){
		List<String> emails = customerService.getAllEmail();
		return new ResponseEntity<>(emails,HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/delete",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> deleteCustomer(@RequestParam (name="id") int id){
		customerService.deleteCustomer(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

	@RequestMapping(path="/validate",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> validateCustomer(@RequestBody Customer cusVO){
		Customer customer = customerService.validateCustomer(cusVO.getEmail(), cusVO.getPassword());
		if(customer==null)
		{
			return new ResponseEntity<>("Customer Not Found", HttpStatus.NOT_FOUND);				
		}	

		return new ResponseEntity<>(customer, HttpStatus.OK);	
	}
	
	
}
