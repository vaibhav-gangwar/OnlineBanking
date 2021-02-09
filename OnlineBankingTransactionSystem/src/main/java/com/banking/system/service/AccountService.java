package com.banking.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.system.entity.Account;
import com.banking.system.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;

	public Account saveAccount(Account account) {
		account = accountRepository.save(account);
		return account;
	}
	
	public List<Account> getAll() {
		List<Account> accountList = accountRepository.findAll();
		return accountList;
	}
	

	public Account getAccountById(String id) {
		Account account = accountRepository.getOne(id);
		return account;
	}
	public void deleteAccount(String id) {
		accountRepository.deleteById(id);
		
	}

	public Account getAccountByCustomerId(String customerId) {
		Account account = accountRepository.getAccountByCustomerId(customerId);
		return account;
	}

	public float getBalanceByCustomerId(String customerId) {
		return  accountRepository.getBalanceByCustomerId(customerId);

	}
	
	@Transactional
	public void fundTransfer(String fromEmailId, String toEmailId, float transferAmount) {
		Account fromAccount = accountRepository.findAccountByEmail(fromEmailId);
		Account toAccount = accountRepository.findAccountByEmail(toEmailId);
		
		fromAccount.setBalance(fromAccount.getBalance()-transferAmount);
		toAccount.setBalance(toAccount.getBalance()+transferAmount);
		
		List<Account> accounts=new ArrayList <>();
		accounts.add(fromAccount);
		accounts.add(toAccount);
		accountRepository.saveAll(accounts);
	}
	
	public float getAccountBalance(int customerId) {
		return accountRepository.getAccountBalance(customerId);
	}
	public float getFDBalance(int customerId) {
		return accountRepository.getFDBalance(customerId);
	}
	
	@Transactional
	public void debitFromAccount(String fromEmailId, float debitAmount) {
		Account fromAccount = accountRepository.findAccountByEmail(fromEmailId);
		fromAccount.setBalance(fromAccount.getBalance()-debitAmount);
		List<Account> accounts=new ArrayList <>();
		accounts.add(fromAccount);
		accountRepository.saveAll(accounts);
	}
	
	@Transactional
	public void creditToAccount(String fromEmailId, float creditAmount) {
		Account toAccount = accountRepository.findAccountByEmail(fromEmailId);
		toAccount.setBalance(toAccount.getBalance()+creditAmount);
		List<Account> accounts=new ArrayList <>();
		accounts.add(toAccount);
		accountRepository.saveAll(accounts);
	}
	
}
