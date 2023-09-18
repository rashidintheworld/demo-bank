package com.example.bankdemoproject.dto.respond;

import com.example.bankdemoproject.entity.Account;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RespTransaction {
    Long dtAccountId;
    String crAccount;
    Double amount;
    Double commission;
    String currency;
}
