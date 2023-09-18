package com.example.bankdemoproject.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqTransaction {
     Long fromAccountId;
     String toAccount;
     Double amount;
     Double commission;
     String currency;
}
