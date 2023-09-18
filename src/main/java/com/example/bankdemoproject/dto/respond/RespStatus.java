package com.example.bankdemoproject.dto.respond;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RespStatus {
    private Integer code;
    private String message;

    private static final Integer SUCCES_CODE=1;
    private static final String SUCCES_MESSAGE="SUCCES";

    public static RespStatus getSuccesMessage(){
        return new RespStatus(SUCCES_CODE,SUCCES_MESSAGE);
    }


}
