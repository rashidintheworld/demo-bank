package com.example.bankdemoproject.dto.respond;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespTransaction {
    RespAccount respAccount;
    String toAccount;
    Double amount;
    Double commission;
    String currency;
}
