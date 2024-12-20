
package Proxy;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;


/**
 * This class was generated by the XML-WS Tools.
 * XML-WS Tools 4.0.3
 * Generated source version: 3.0
 * 
 */
@WebService(name = "BanqueService", targetNamespace = "http://TP1.market.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BanqueService {


    /**
     * 
     * @param arg0
     * @return
     *     returns double
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "conversionEuroDirhams", targetNamespace = "http://TP1.market.com/", className = "Proxy.ConversionEuroDirhams")
    @ResponseWrapper(localName = "conversionEuroDirhamsResponse", targetNamespace = "http://TP1.market.com/", className = "Proxy.ConversionEuroDirhamsResponse")
    @Action(input = "http://TP1.market.com/BanqueService/conversionEuroDirhamsRequest", output = "http://TP1.market.com/BanqueService/conversionEuroDirhamsResponse")
    public double conversionEuroDirhams(
        @WebParam(name = "arg0", targetNamespace = "")
        double arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns Proxy.Compte
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccount", targetNamespace = "http://TP1.market.com/", className = "Proxy.GetAccount")
    @ResponseWrapper(localName = "getAccountResponse", targetNamespace = "http://TP1.market.com/", className = "Proxy.GetAccountResponse")
    @Action(input = "http://TP1.market.com/BanqueService/getAccountRequest", output = "http://TP1.market.com/BanqueService/getAccountResponse")
    public Compte getAccount(
        @WebParam(name = "arg0", targetNamespace = "")
        Compte arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<Proxy.Compte>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAccounts", targetNamespace = "http://TP1.market.com/", className = "Proxy.GetAccounts")
    @ResponseWrapper(localName = "getAccountsResponse", targetNamespace = "http://TP1.market.com/", className = "Proxy.GetAccountsResponse")
    @Action(input = "http://TP1.market.com/BanqueService/getAccountsRequest", output = "http://TP1.market.com/BanqueService/getAccountsResponse")
    public List<Compte> getAccounts(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Compte> arg0);

}
