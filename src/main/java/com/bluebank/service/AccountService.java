package main.java.com.bluebank.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.bluebank.model.Account;
import main.java.com.bluebank.repository.AccountRepository;

@Service("accountService")
@Transactional
public class AccountService {

	@Autowired
	private AccountRepository accRepo;
	
	public Account saveAccount(Account account) {
		return accRepo.saveAndFlush(account);
	}
	
	@PostConstruct
	public void fillTestAccounts() {
		Account arg0 = new Account();
		arg0.setVersion(1L);
		arg0.setAccountNumber("201612230324D1029381");
		
		accRepo.saveAndFlush(arg0);
		
		Account arg1 = new Account();
		arg1.setVersion(1L);
		arg1.setAccountNumber("201612230324D1029322");
		
		accRepo.saveAndFlush(arg1);
	}
}
