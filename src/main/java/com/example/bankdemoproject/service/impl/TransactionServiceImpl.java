package com.example.bankdemoproject.service.impl;

import com.example.bankdemoproject.dto.request.ReqTransaction;
import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.dto.respond.RespStatus;
import com.example.bankdemoproject.dto.respond.RespTransaction;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.entity.Account;
import com.example.bankdemoproject.entity.Customer;
import com.example.bankdemoproject.entity.Transaction;
import com.example.bankdemoproject.enums.EnumAvailableStatus;
import com.example.bankdemoproject.exception.CustomException;
import com.example.bankdemoproject.exception.ExceptionConstants;
import com.example.bankdemoproject.exception.ResourceNotFoundException;
import com.example.bankdemoproject.mapper.TransactionMapper;
import com.example.bankdemoproject.repository.AccountRepository;
import com.example.bankdemoproject.repository.TransactionRepository;
import com.example.bankdemoproject.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.hibernate.id.enhanced.AccessCallback;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.bankdemoproject.service.impl.AccountServiceImpl.ACCOUNT_NOT_FOUND_MESSAGE;
import static com.example.bankdemoproject.service.impl.CustomerServiceImpl.ID_MESSAGE;
import static com.example.bankdemoproject.service.impl.CustomerServiceImpl.LIST_MESSAGE;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    private final AccountRepository accountRepository;

    private final TransactionMapper transactionMapper;
    private final String TRANSACTION_NOT_FOUND_MESSAGE = "Transaction not found!";
    @Override
    public Response<List<RespTransaction>> getTransactionList(Long accountId) {
        Response<List<RespTransaction>> response = new Response<>();
        if(accountId==null){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA,ID_MESSAGE);
        }
        Account account = accountRepository.findAccountByIdAndActive(accountId, EnumAvailableStatus.ACTIVE.value);
        if(account==null){
            throw new ResourceNotFoundException(ExceptionConstants.ACCOUNT_NOT_FOUND,ACCOUNT_NOT_FOUND_MESSAGE);
        }
        List<Transaction> transactionList = transactionRepository.findAllByFromAccountAndActive(account,EnumAvailableStatus.ACTIVE.value);
        if(transactionList.isEmpty()){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA,LIST_MESSAGE);
        }
        List<RespTransaction> respTransactionList = transactionList.stream().map(transactionMapper::respTransactionToEntity).collect(Collectors.toList());
        response.setT(respTransactionList);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response createOperation(ReqTransaction reqTransaction) {
        Response response = new Response();
        Long fromAccountId = reqTransaction.getFromAccountId();
        Account account = accountRepository.findAccountByIdAndActive(fromAccountId, EnumAvailableStatus.ACTIVE.value);
        if(account==null){
            throw new ResourceNotFoundException(ExceptionConstants.ACCOUNT_NOT_FOUND,ACCOUNT_NOT_FOUND_MESSAGE);
        }
        Transaction transaction = Transaction.builder()
                .fromAccount(account)
                .toAccount(reqTransaction.getToAccount())
                .amount(reqTransaction.getAmount())
                .commission(reqTransaction.getCommission())
                .currency(reqTransaction.getCurrency())
                .build();
        transactionRepository.save(transaction);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }
}
