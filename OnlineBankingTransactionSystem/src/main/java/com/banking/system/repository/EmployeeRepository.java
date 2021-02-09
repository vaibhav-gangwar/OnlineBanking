package com.banking.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.system.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
	
	@Query(value="Select e from Employee e Where e.email = :email and e.password = :password")
	public Employee validateEmployee(@Param ("email")String email,@Param ("password") String password);

}
