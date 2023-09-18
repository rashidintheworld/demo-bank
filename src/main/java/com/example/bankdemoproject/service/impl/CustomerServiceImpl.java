package com.example.bankdemoproject.service.impl;

import com.example.bankdemoproject.dto.request.ReqCustomer;
import com.example.bankdemoproject.dto.respond.RespCustomer;
import com.example.bankdemoproject.dto.respond.RespStatus;
import com.example.bankdemoproject.dto.respond.RespTransaction;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.entity.Customer;
import com.example.bankdemoproject.enums.EnumAvailableStatus;
import com.example.bankdemoproject.exception.CustomException;
import com.example.bankdemoproject.exception.ExceptionConstants;
import com.example.bankdemoproject.exception.ResourceNotFoundException;
import com.example.bankdemoproject.mapper.CustomerMapper;
import com.example.bankdemoproject.repository.CustomerRepository;
import com.example.bankdemoproject.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public static final String ID_MESSAGE = "ID is null!";
    private final CustomerMapper customerMapper;
    public static final String CUSTOMER_NOT_FOUND_MESSAGE = "Customer not found!";
    public static final String LIST_MESSAGE = "List is empty";
    @Override
    public Response<List<RespCustomer>> getCustomerList() {
        Response<List<RespCustomer>> response = new Response<>();
        List<Customer> customerList = customerRepository.findAllByActive(EnumAvailableStatus.ACTIVE.value);
        if(customerList.isEmpty()){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA, LIST_MESSAGE);
        }
        List<RespCustomer> respCustomerList = customerList.stream().map(customerMapper::customerEntityToDto).collect(Collectors.toList());
        response.setT(respCustomerList);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response<RespCustomer> getCustomerById(Long id) {
        Response<RespCustomer> response = new Response<>();
        if(id==null){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA, ID_MESSAGE);
        }
        Customer customer = customerRepository.findCustomerByIdAndActive(id,EnumAvailableStatus.ACTIVE.value);
        if(customer==null){
            throw new ResourceNotFoundException(ExceptionConstants.CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND_MESSAGE);
        }
        RespCustomer respCustomer = customerMapper.customerEntityToDto(customer);
        response.setT(respCustomer);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response addCustomer(ReqCustomer reqCustomer) {
        Response response = new Response();
        Customer customer = customerMapper.dtoToCustomerEntity(reqCustomer);
        if(customer == null){
            throw new ResourceNotFoundException(ExceptionConstants.CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND_MESSAGE);
        }
        Customer createdCustomer = Customer.builder()
                .name(reqCustomer.getName())
                .surname(reqCustomer.getSurname())
                .pin(reqCustomer.getPin())
                .seria(reqCustomer.getSeria())
                .dob(reqCustomer.getDob())
                .phone(reqCustomer.getPhone())
                .address(reqCustomer.getAddress())
                .build();
        customerRepository.save(createdCustomer);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response updateCustomer(ReqCustomer reqCustomer) {
        Response response = new Response();
        Long id = reqCustomer.getId();
        Customer customer = customerRepository.findCustomerByIdAndActive(id,EnumAvailableStatus.ACTIVE.value);
        if(customer == null){
            throw new ResourceNotFoundException(ExceptionConstants.CUSTOMER_NOT_FOUND, CUSTOMER_NOT_FOUND_MESSAGE);
        }
        Customer updatedCustomer = Customer.builder()
                .name(reqCustomer.getName())
                .surname(reqCustomer.getSurname())
                .pin(reqCustomer.getPin())
                .seria(reqCustomer.getSeria())
                .dob(reqCustomer.getDob())
                .phone(reqCustomer.getPhone())
                .address(reqCustomer.getAddress())
                .build();
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }

    @Override
    public Response deleteCustomer(Long id) {
        Response response = new Response();
        if(id==null){
            throw new CustomException(ExceptionConstants.INVALID_REQUEST_DATA, ID_MESSAGE);
        }
        Customer customer = customerRepository.findCustomerByIdAndActive(id,EnumAvailableStatus.ACTIVE.value);
        if(customer==null){
            throw new ResourceNotFoundException(ExceptionConstants.CUSTOMER_NOT_FOUND, "Not found!");
        }
        customer.setActive(EnumAvailableStatus.DEACTIVE.value);
        customerRepository.save(customer);
        response.setRespStatus(RespStatus.getSuccesMessage());
        return response;
    }
}
