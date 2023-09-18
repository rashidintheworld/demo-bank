package com.example.bankdemoproject.service;

import com.example.bankdemoproject.dto.request.ReqTransaction;
import com.example.bankdemoproject.dto.respond.RespTransaction;
import com.example.bankdemoproject.dto.respond.Response;

import java.util.List;

public interface TransactionService {

    Response<List<RespTransaction>> getTransactionList(Long accountId);
    Response createOperation(ReqTransaction reqTransaction);
}
