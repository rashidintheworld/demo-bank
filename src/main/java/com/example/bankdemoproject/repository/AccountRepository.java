package com.example.bankdemoproject.repository;

import com.example.bankdemoproject.entity.Account;
import com.example.bankdemoproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    List<Account> findAllByCustomerAndActive(Customer customer, Integer active);
    Account findAccountByIdAndActive(Long accountId,Integer active);
}
