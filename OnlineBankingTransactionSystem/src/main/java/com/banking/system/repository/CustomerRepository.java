package com.banking.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.system.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	
	@Query(value="Select lower(c.email) from Customer c")
	public List<String> findAllEmailIds();

	@Query(value="Select c from Customer c Where c.email = :email and c.password = :password")
	public Customer validateCustomer(@Param ("email")String email,@Param ("password") String password);
	

	@Query(value="Select c.CUST_ID from Customer c Where c.email = :email",nativeQuery=true)
	public int getCustomerIdByEmail(@Param ("email")String email);
}



