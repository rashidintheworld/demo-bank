package com.example.bankdemoproject.controller;


import com.example.bankdemoproject.dto.request.ReqTransaction;
import com.example.bankdemoproject.dto.respond.RespTransaction;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/{id}")
    public Response<List<RespTransaction>> getTransactionList(@PathVariable Long accountId) {
        return transactionService.getTransactionList(accountId);
    }

    @PostMapping
    public Response saveTransaction(@RequestBody ReqTransaction reqTransaction) {
        return transactionService.createOperation(reqTransaction);
    }
}
