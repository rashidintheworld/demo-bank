package com.example.bankdemoproject.repository;

import com.example.bankdemoproject.entity.Account;
import com.example.bankdemoproject.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {
    List<Transaction> findAllByFromAccountAndActive(Account account, Integer active);
}
