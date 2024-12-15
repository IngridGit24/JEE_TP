package org.sid.bank_account_service.dto;

import lombok.*;
import org.sid.bank_account_service.enums.AccountType;
import java.util.Date;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
    private String id;
    private Date createdDte;
    private Double balance;
    private String currency;
    private AccountType type;
}
