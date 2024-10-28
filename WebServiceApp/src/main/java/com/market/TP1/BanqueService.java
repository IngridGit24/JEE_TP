package com.market.TP1;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public class BanqueService {
    @WebMethod
    public double conversionEuroDirhams(@WebParam double amount){
        return amount*11;
    }
    @WebMethod
    public Compte getAccount(@WebParam Compte account){
        return account;
    };
    @WebMethod
    public List<Compte> getAccounts(@WebParam List<Compte> accounts){
        return accounts;
    }
}
