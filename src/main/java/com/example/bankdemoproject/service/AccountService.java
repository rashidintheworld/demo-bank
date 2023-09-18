package com.example.bankdemoproject.service;


import com.example.bankdemoproject.dto.request.ReqAccount;
import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.dto.respond.Response;

import java.util.List;

public interface AccountService {
    Response<List<RespAccount>> getAccountListByCustomerId(Long customerId);
    Response createAccount(ReqAccount reqAccount);
}
