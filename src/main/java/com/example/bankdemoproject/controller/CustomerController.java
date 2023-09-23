package com.example.bankdemoproject.controller;


import com.example.bankdemoproject.dto.request.ReqCustomer;
import com.example.bankdemoproject.dto.respond.RespCustomer;
import com.example.bankdemoproject.dto.respond.Response;
import com.example.bankdemoproject.entity.Customer;
import com.example.bankdemoproject.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/list")
    public Response<List<RespCustomer>> getCustomerList() {
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public Response<RespCustomer> getCustomerById(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public Response addCustomer(@RequestBody @Valid ReqCustomer reqCustomer) {
        return customerService.addCustomer(reqCustomer);
    }

    @PutMapping
    public Response updateCustomer(@RequestBody ReqCustomer reqCustomer) {
        return customerService.updateCustomer(reqCustomer);
    }

    @PutMapping("/{id}")
    public Response deleteCustomer(@PathVariable Long id) {
        return customerService.deleteCustomer(id);
    }

}
