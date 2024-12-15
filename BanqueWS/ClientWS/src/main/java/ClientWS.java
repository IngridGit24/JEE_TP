import Proxy.BanqueService;
import Proxy.BanqueWS;
import Proxy.Compte;

public class ClientWS {
    public static void main(String[] args) {
        BanqueService stub = new BanqueWS().getBanqueServicePort();
        System.out.println(stub.convert(600));

        Compte compte = stub.getCompte(1000);
        System.out.println(compte.getCode());
        System.out.println(compte.getSolde());


    }
}
