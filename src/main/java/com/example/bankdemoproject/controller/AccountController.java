package com.example.bankdemoproject.controller;


import com.example.bankdemoproject.dto.request.ReqAccount;
import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/{id}")
    public Response<List<RespAccount>> getAccountsListByCustomerId(@PathVariable Long customerId){
        return accountService.getAccountListByCustomerId(customerId);
    }

    @PostMapping
    public Response saveAccount(@RequestBody ReqAccount reqAccount){
        return accountService.createAccount(reqAccount);
    }
}
