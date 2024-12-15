package org.sid.bank_account_service.web;

import org.sid.bank_account_service.dto.BankAccountRequestDTO;
import org.sid.bank_account_service.dto.BankAccountResponseDTO;
import org.sid.bank_account_service.entities.BankAccount;
import org.sid.bank_account_service.mappers.AccountMapper;
import org.sid.bank_account_service.repositories.BankAccountRepository;
import org.sid.bank_account_service.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private BankAccountRepository bankAccountRepository;

    private AccountService accountService;

    private AccountMapper accountMapper;

    public AccountRestController( BankAccountRepository aBankAccountRepository) {
        this.bankAccountRepository = aBankAccountRepository;
    }

    //Methode pour récuperer la liste des comptes
    //localhost:8080/bankAccounts
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    //Methode pour récuperer un comptes à l'aide de son id
    //Exemple id = e278d11f-d5c1-45d0-a456-6a05aa412689
    //localhost:8080/bankAccount/e278d11f-d5c1-45d0-a456-6a05aa412689
    @GetMapping("/bankAccount/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account with id %s not found!",id)));
    }

    // Méthode pour ajouter un compte
    //http://localhost:8080/bankAccount
    @PostMapping("/bankAccount")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO) {
        //if(newBankAccount.getId() == null) newBankAccount.setId(UUID.randomUUID().toString());
        return accountService.addAccount(requestDTO);
    }

    // Méthode pour modifier un compte
    //Exemple id = e278d11f-d5c1-45d0-a456-6a05aa412689
    //http://localhost:8080/bankAccount/e278d11f-d5c1-45d0-a456-6a05aa412689
    @PutMapping("/bankAccount/{id}")
    public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount updatedBankAccount) {
        BankAccount existingAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found"));

        // Met à jour les détails du compte
        if(updatedBankAccount.getBalance()!=null) existingAccount.setBalance(updatedBankAccount.getBalance());
        if(updatedBankAccount.getCurrency()!=null) existingAccount.setCurrency(updatedBankAccount.getCurrency());
        if(updatedBankAccount.getCreatedDte()!=null) existingAccount.setCreatedDte(updatedBankAccount.getCreatedDte());
        if(updatedBankAccount.getType()!=null) existingAccount.setType(updatedBankAccount.getType());

        return bankAccountRepository.save(existingAccount);
    }

    // Méthode pour supprimer un compte
    //Exemple id = e278d11f-d5c1-45d0-a456-6a05aa412689
    //http://localhost:8080/bankAccount/e278d11f-d5c1-45d0-a456-6a05aa412689
    @DeleteMapping("/bankAccount/{id}")
    public void deleteBankAccount(@PathVariable String id) {
        BankAccount existingAccount = bankAccountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account with id " + id + " not found"));

        bankAccountRepository.delete(existingAccount);
    }


}
