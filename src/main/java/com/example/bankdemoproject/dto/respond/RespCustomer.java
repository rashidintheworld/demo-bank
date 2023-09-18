package com.example.bankdemoproject.dto.respond;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespCustomer {
    Long customerId;
    String name;
    String surname;
    String address;
    String pin;
    String seria;
    Date dob;
    String phone;
    String cif;
}
