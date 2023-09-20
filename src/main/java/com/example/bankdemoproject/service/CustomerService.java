package com.example.bankdemoproject.service;

import com.example.bankdemoproject.dto.request.ReqCustomer;
import com.example.bankdemoproject.dto.respond.RespCustomer;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {
    Response<List<RespCustomer>> getCustomerList();

    Response<RespCustomer> getCustomerById(Long id);
    Response addCustomer(ReqCustomer reqCustomer);
    Response updateCustomer(ReqCustomer reqCustomer);

    Response deleteCustomer(Long id);
}
