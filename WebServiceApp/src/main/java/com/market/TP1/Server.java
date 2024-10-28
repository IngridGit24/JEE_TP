package com.market.TP1;

import jakarta.xml.ws.Endpoint;

public class Server {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:2000/BanqueService", new BanqueService());
        System.out.println("Service BanqueService est en cours d'exécution sur http://localhost:2000/BanqueService");
    }
}
