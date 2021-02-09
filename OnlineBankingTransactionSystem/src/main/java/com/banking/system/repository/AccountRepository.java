package com.banking.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.system.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,String> {
	@Query(value="select a from Account a join fetch a.customer c where c.email=:email")
	public Account findAccountByEmail(@Param("email") String email);
	
	@Query(value="SELECT balance from account a inner join customer c on a.cust_id=c.cust_id where c.cust_id=:customerId",nativeQuery=true)
	public float getAccountBalance(@Param("customerId") int customerId);

	@Query(value="select balance from customer c inner join fd f on f.cust_id=c.cust_id where c.cust_id=:customerId",nativeQuery=true)
	public float getFDBalance(@Param("customerId") int customerId);

	@Query(value="SELECT a.* from account a inner join customer c on a.cust_id=c.cust_id where c.cust_id=:customerId",nativeQuery=true)
	public Account getAccountByCustomerId(@Param("customerId") String customerId);
	
	@Query(value="select a.Balance, f.Balance FDBalance from customer c inner join account a on a.cust_id=c.cust_id inner join fd f on f.cust_id=c.cust_id where c.cust_id=:customerId",nativeQuery=true)
	public float getBalanceByCustomerId(@Param("customerId") String customerId);

}
