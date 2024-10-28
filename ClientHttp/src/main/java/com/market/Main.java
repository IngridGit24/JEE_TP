package com.market;

import Proxy.BanqueService;
import Proxy.BanqueServiceService;
import Proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueServiceService().getBanqueServicePort();

        Compte newAccount = new Compte();
        newAccount.setCode(2024);
        newAccount.setSolde(145000.095);

        Compte stub = proxy.getAccount(newAccount);
        System.out.println("Le solde du compte : "+ newAccount.getSolde());

        System.out.println("Methode de Concersion : "+ proxy.conversionEuroDirhams(21000.45));
    }
}