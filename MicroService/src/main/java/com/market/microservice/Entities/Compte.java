package com.market.microservice.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data @Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int code;
    private double solde;
    private String proprietaire;

    public Compte(int code, double solde, String proprietaire) {
        this.code = code;
        this.solde = solde;
        this.proprietaire = proprietaire;
    }
}
