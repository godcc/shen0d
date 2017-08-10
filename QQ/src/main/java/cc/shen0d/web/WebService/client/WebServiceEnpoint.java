
package cc.shen0d.web.WebService.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "WebServiceEnpoint", targetNamespace = "http://enpoint.WebService.web.shen0d.cc/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WebServiceEnpoint {


    /**
     * 
     * @param password
     * @param name
     * @return
     *     returns cc.shen0d.Webservicetest1.WebServiceTest
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWebServiceTest", targetNamespace = "http://enpoint.WebService.web.shen0d.cc/", className = "cc.shen0d.Webservicetest1.GetWebServiceTest")
    @ResponseWrapper(localName = "getWebServiceTestResponse", targetNamespace = "http://enpoint.WebService.web.shen0d.cc/", className = "cc.shen0d.Webservicetest1.GetWebServiceTestResponse")
    public WebServiceTest getWebServiceTest(
        @WebParam(name = "name", targetNamespace = "")
        String name,
        @WebParam(name = "password", targetNamespace = "")
        String password);

}
