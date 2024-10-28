package com.market.TP1;

public class Compte {
    private double solde;
    private int code;

    //Constructors
    public Compte() {
    }

    public Compte(double solde, int code) {
        this.solde = solde;
        this.code = code;
    }

    //Tostring method


    @Override
    public String toString() {
        return "Compte{" +
                "solde=" + solde +
                ", code=" + code +
                '}';
    }

    //Getters and Setters
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
