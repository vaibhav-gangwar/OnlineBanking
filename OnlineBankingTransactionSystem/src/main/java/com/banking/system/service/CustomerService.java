package com.banking.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.system.entity.Customer;
import com.banking.system.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
		customer = customerRepository.save(customer);
		return customer;
	}
	
	public List<Customer> getAll() {
		List<Customer> customerList =customerRepository.findAll();
		return customerList;
	}
	
	public void deleteCustomer(int id) {
		customerRepository.deleteById(id);
	}
	
	public List<String> getAllEmail() {
		List<String> emailIds =customerRepository.findAllEmailIds();
		return emailIds;
	}

	public Customer validateCustomer(String email, String password) {
		return customerRepository.validateCustomer(email, password);
	}

	public int getCustomerIdByEmail(String email) {
		return customerRepository.getCustomerIdByEmail(email);
	}
	
}
