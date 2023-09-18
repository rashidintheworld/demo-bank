package com.example.bankdemoproject.service.impl;

import com.example.bankdemoproject.dto.request.ReqAccount;
import com.example.bankdemoproject.dto.respond.RespAccount;
import com.example.bankdemoproject.dto.respond.RespStatus;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.entity.Account;
import com.example.bankdemoproject.entity.Customer;
import com.example.bankdemoproject.enums.EnumAvailableStatus;
import com.example.bankdemoproject.exception.CustomException;
import com.example.bankdemoproject.exception.ExceptionConstants;
import com.example.bankdemoproject.exception.ResourceNotFoundException;
import com.example.bankdemoproject.mapper.AccountMapper;
import com.example.bankdemoproject.repository.AccountRepository;
import com.example.bankdemoproject.repository.CustomerRepository;
import com.example.bankdemoproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.bankdemoproject.service.impl.CustomerServiceImpl.*;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;
    private final AccountMapper accountMapper;
    public static String ACCOUNT_NOT_FOUND_MESSAGE = "Account not found!";

    @Override
    public Response<List<RespAccount>> getAccountListByCustomerId(Long customerId) {
        Response response = new Response();
        if(customerId==null){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA,ID_MESSAGE);
        }
        Customer customer = customerRepository.findCustomerByIdAndActive(customerId, EnumAvailableStatus.ACTIVE.value);
        if(customer == null){
            throw new ResourceNotFoundException(ExceptionConstants.ACCOUNT_NOT_FOUND, ACCOUNT_NOT_FOUND_MESSAGE);
        }
        List<Account> accountList = accountRepository.findAllByCustomerAndActive(customer,EnumAvailableStatus.ACTIVE.value);
        if(accountList.isEmpty()){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA,LIST_MESSAGE);
        }
        List<RespAccount> respAccountList = accountList.stream().map(accountMapper::respAccountToEntity).collect(Collectors.toList());
        response.setT(respAccountList);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response createAccount(ReqAccount reqAccount) {
        Response response = new Response();
        Long customerId = reqAccount.getCustomerId();
        Customer customer = customerRepository.findCustomerByIdAndActive(customerId,EnumAvailableStatus.ACTIVE.value);
        if(customer==null){
            throw new ResourceNotFoundException(ExceptionConstants.CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND_MESSAGE);
        }
        Account account = Account.builder()
                .name(reqAccount.getName())
                .accountNo(reqAccount.getAccountNo())
                .iban(reqAccount.getIban())
                .branchCode(reqAccount.getBranchCode())
                .currency(reqAccount.getCurrency())
                .customer(customer)
                .build();
        accountRepository.save(account);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }
}
