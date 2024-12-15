package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;

//POJA Plain Of Java Object
@WebService(serviceName = "BanqueWS")
public class BanqueService {

    @WebMethod(operationName = "Convert")
    public double conversion(@WebParam(name = "montant") double montant){
        return montant * 10.54;
    }

    @WebMethod
    public Compte getCompte(@WebParam(name = "code") int code){
        return new Compte(code, Math.random()*9888, new Date());
    }

    @WebMethod
    public List<Compte> listComptes(){
        return List.of(
                new Compte(1000, Math.random()*9888, new Date()),
                new Compte(2000, Math.random()*9789, new Date()),
                new Compte(3000, Math.random()*9858, new Date()),
                new Compte(3005, Math.random()*9480, new Date()),
                new Compte(4000, Math.random()*9880, new Date())
        );
    }
}
