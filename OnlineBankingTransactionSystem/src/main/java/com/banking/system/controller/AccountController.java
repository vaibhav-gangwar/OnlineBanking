package com.banking.system.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.system.entity.Account;
import com.banking.system.entity.CreditToAccountVO;
import com.banking.system.entity.DebitFromAccountVO;
import com.banking.system.entity.FundTranferVO;
import com.banking.system.service.AccountService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;

	@RequestMapping(path="/save",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveAccount(@RequestBody Account account){
		account=accountService.saveAccount(account);
		return new ResponseEntity<>(account,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(path="/getall",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAllAccount(){
		List<Account> accountList = accountService.getAll();
		return new ResponseEntity<>(accountList,HttpStatus.OK);		
	}
	
	@RequestMapping(path="/delete",method=RequestMethod.DELETE,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> deleteAccount(@RequestParam (name="id") String id){
		accountService.deleteAccount(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
	}
	

	@RequestMapping(path="/getById",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAccountById(@RequestParam (name="id") String id){
		Account acc= accountService.getAccountById(id);
		return new ResponseEntity<>(acc, HttpStatus.OK);
		
	}

	@RequestMapping(path="/getByCustomerId",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getByCustomerId(@RequestParam (name="customerId") String customerId){
		Account acc= accountService.getAccountByCustomerId(customerId);
		return new ResponseEntity<>(acc, HttpStatus.OK);		
	}

	@RequestMapping(path="/getBalByCustomerId",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getBalByCustomerId(@RequestParam (name="customerId") int customerId){
		float balance=	accountService.getAccountBalance(customerId);
		float fdbalance=	accountService.getFDBalance(customerId);
		Map<String,Float> result= new HashMap<>();
		result.put("Balance", balance);
		result.put("FDBalance", fdbalance);
		return new ResponseEntity<>(result, HttpStatus.OK);		
	}
	
	
	@RequestMapping(path="/transfer",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getFundTransfer(@RequestBody FundTranferVO fundTranferVO){
		accountService.fundTransfer(fundTranferVO.getFromEmailId(), fundTranferVO.getToEmailId(), fundTranferVO.getTransferAmount());
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/balance/{customerId}",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getAccountBalance(@PathVariable(name="customerId") int customerId){
		float balance = accountService.getAccountBalance(customerId);
		Map<String,Float> result= new HashMap<>();
		result.put("Balance", balance);
		return new ResponseEntity<>(result,HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/debitFromAccount",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getDebitFromAccount(@RequestBody DebitFromAccountVO debitFromAccountVO){
		accountService.debitFromAccount(debitFromAccountVO.getFromEmailId(), debitFromAccountVO.getDebitAmount());
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	@RequestMapping(path="/creditToAccount",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> getCreditToAccount(@RequestBody CreditToAccountVO creditToAccountVO){
		accountService.creditToAccount(creditToAccountVO.getFromEmailId(), creditToAccountVO.getCreditAmount());
		return new ResponseEntity<>( HttpStatus.OK);
		
	}
	
	

}			
