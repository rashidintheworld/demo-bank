package com.example.bankdemoproject.mapper;

import com.example.bankdemoproject.dto.request.ReqCustomer;
import com.example.bankdemoproject.dto.respond.RespCustomer;
import com.example.bankdemoproject.entity.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer dtoToCustomerEntity(ReqCustomer reqCustomer);
    RespCustomer customerEntityToDto(Customer customer);
}
