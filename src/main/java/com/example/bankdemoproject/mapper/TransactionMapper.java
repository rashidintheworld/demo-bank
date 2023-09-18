package com.example.bankdemoproject.mapper;

import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.dto.respond.RespTransaction;
import com.example.bankdemoproject.entity.Account;
import com.example.bankdemoproject.entity.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    RespTransaction respTransactionToEntity(Transaction transaction);

}
