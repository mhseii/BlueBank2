package main.java.com.bluebank.repository;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import main.java.com.bluebank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	Account findByAccountNumber(String accountNumber);

	@Override
	@Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
	Account save(Account account);
}
