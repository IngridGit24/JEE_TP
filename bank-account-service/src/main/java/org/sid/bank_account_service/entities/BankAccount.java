package org.sid.bank_account_service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;
import org.sid.bank_account_service.enums.AccountType;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class BankAccount {

    @Id
    private String id;
    private Date createdDte;
    private Double balance;
    private String currency;

    @Enumerated(EnumType.STRING)
    private AccountType type;
}