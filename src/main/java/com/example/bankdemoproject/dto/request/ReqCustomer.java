package com.example.bankdemoproject.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ReqCustomer {
    String name;
    String surname;
    String pin;
    String seria;
    Date dob;
    String phone;
    String address;
    String cif;
}
