package com.example.bankdemoproject.mapper;

import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.entity.Account;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    RespAccount respAccountToEntity(Account account);
}
