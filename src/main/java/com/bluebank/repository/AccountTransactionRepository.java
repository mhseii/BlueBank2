package main.java.com.bluebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import main.java.com.bluebank.model.AccountTransaction;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction,Long>{

}
