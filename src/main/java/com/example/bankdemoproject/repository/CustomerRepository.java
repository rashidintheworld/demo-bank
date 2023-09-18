package com.example.bankdemoproject.repository;

import com.example.bankdemoproject.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findAllByActive(Integer active);
    Customer findCustomerByIdAndActive(Long id,Integer active);
}
