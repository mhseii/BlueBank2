package main.java.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.bluebank.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	Account findByAccountNumber(String accountNumber);
}
