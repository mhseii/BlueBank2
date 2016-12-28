package main.java.com.bluebank.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.bluebank.model.Account;
import main.java.com.bluebank.service.AccountService;
import main.java.com.bluebank.web.dto.TransactionDTO;

@RestController
public class AccountManagementController {

	AccountService svc;
	
	@Autowired
	public AccountManagementController(AccountService svc) {
		this.svc = svc;
	}
	
	@RequestMapping(value = "/retrieve_balance", method = RequestMethod.GET)
	public String retrieveBalance(TransactionDTO transaction) {
		// retrieve balance
		Account acc = svc.retrieveAccount(transaction.getSourceAccountNumber());
		// send general account info and balance as JSON
		acc.getBalance();
		return null;
	}
	
}
