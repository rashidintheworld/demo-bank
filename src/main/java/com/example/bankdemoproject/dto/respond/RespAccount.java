package com.example.bankdemoproject.dto.respond;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespAccount {
    Long id;
    String name;
    String accountNo;
    String iban;
    String currency;
    Integer branchCode;
    RespCustomer respCustomer;
}
