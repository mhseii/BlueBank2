package test.java;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.persistence.OptimisticLockException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.web.ServletTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import main.java.com.bluebank.config.PersistenceConfig;
import main.java.com.bluebank.config.WebConfig;
import main.java.com.bluebank.config.WebInit;
import main.java.com.bluebank.model.Account;
import main.java.com.bluebank.repository.AccountRepository;
import main.java.com.bluebank.service.AccountService;
import main.java.com.bluebank.web.dto.TransactionDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { WebInit.class, WebConfig.class, PersistenceConfig.class })
@WebAppConfiguration
@TestExecutionListeners({ServletTestExecutionListener.class,
	DependencyInjectionTestExecutionListener.class})
public class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	AccountService accountService;

	protected static final String ACCOUNT_NUMBER = "201612230130D89172";
	
	@Test
	public void dependencyInjectionTest() {
		assertNotNull(String.format("failed to inject %s", accountRepository.toString()), accountRepository);
		assertNotNull(String.format("failed to inject %s", accountService.toString()), accountRepository);
	}

	@Test
	public void repositorySaveTest() {
		Account acc = new Account();
		acc.setAccountNumber(ACCOUNT_NUMBER);
		acc.setBalance(new BigDecimal("1000.00"));
		assertNotNull(accountRepository.save(acc));
	}
	/*
	@Test
	public void respositoryFindByAccountNumberTest() {
		Account acc = accountRepository.findByAccountNumber(ACCOUNT_NUMBER);
		assertNotNull(acc);
	}
	
	@Test
	public void depositTest() {
		
		TransactionDTO transaction = new TransactionDTO();
		transaction.setSourceAccountNumber(ACCOUNT_NUMBER);
		transaction.setAmount(new BigDecimal("100.00"));
		Account acc = accountService.deposit(transaction);
		assertEquals(new BigDecimal("1100.00"),acc.getBalance());
	}
	*/
	@Test(expected = OptimisticLockException.class)
	public void repositoryOptimisticLockExceptionTest() {
		Account acc = new Account();
		acc.setAccountNumber(ACCOUNT_NUMBER);
		acc.setBalance(new BigDecimal("400.00"));
		accountRepository.save(acc);
		accountRepository.save(acc);
	}
}
