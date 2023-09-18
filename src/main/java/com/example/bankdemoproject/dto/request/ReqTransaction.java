package com.example.bankdemoproject.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqTransaction {
     //Long dtAccountId;
     String  crAccount;
     Double amount;
     Double commission;
     String currency;
}
