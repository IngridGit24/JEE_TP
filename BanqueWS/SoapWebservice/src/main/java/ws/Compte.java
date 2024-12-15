package ws;

import jakarta.xml.bind.annotation.*;
import java.util.Date;

@XmlRootElement(name = "compte")
@XmlAccessorType(XmlAccessType.FIELD)
public class Compte {

    private int code;
    private double solde;

    @XmlTransient
    private Date date_creation;

    public Compte() {
    }

    public Compte(int code, double solde, Date date_creation) {
        this.code = code;
        this.solde = solde;
        this.date_creation = date_creation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }
}
