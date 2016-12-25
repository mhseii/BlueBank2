package main.java.com.bluebank.service;

import main.java.com.bluebank.model.Account;
import main.java.com.bluebank.web.dto.TransactionDTO;

public interface AccountService {
	
	Account deposit(TransactionDTO transaction);
	Account withdraw(TransactionDTO transaction);
	Account transfer(TransactionDTO transaction);
	
}
