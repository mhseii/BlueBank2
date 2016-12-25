package main.java.com.bluebank.service.impl;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.bluebank.model.Account;
import main.java.com.bluebank.model.AccountTransaction;
import main.java.com.bluebank.repository.AccountRepository;
import main.java.com.bluebank.service.AccountService;
import main.java.com.bluebank.web.dto.TransactionDTO;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

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

	@Override
	@Transactional
	public Account deposit(TransactionDTO transaction) {

		if (transaction.getSourceAccountNumber() != null && transaction.getAmount() != null
				&& transaction.getAmount().compareTo(BigDecimal.ZERO) != 0) {
			Account source = accRepo.findByAccountNumber(transaction.getSourceAccountNumber());
			AccountTransaction perfomed = new AccountTransaction(transaction.getAmount(),
					transaction.getTransactionDate(), transaction.getTargetAccountNumber(),
					transaction.getSourceAccountNumber());
			source.getTransactionsList().add(perfomed);
			source.setBalance(source.getBalance().add(transaction.getAmount()));
			System.out.println(source.toString());
			return accRepo.save(source);
		}

		return null;
	}

	@Override
	public Account withdraw(TransactionDTO transaction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account transfer(TransactionDTO transaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
