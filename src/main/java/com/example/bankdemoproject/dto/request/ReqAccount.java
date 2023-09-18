package com.example.bankdemoproject.dto.request;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqAccount {
    String name;
    String accountNo;
    String iban;
    String currency;
    Integer branchCode;
    Long customerId;
}
