
package cc.shen0d.web.WebService.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceEnpointService", targetNamespace = "http://enpoint.WebService.web.shen0d.cc/", wsdlLocation = "http://localhost:9090/ws?wsdl")
public class WebServiceEnpointService
    extends Service
{

    private final static URL WEBSERVICEENPOINTSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEENPOINTSERVICE_EXCEPTION;
    private final static QName WEBSERVICEENPOINTSERVICE_QNAME = new QName("http://enpoint.WebService.web.shen0d.cc/", "WebServiceEnpointService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9090/ws?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEENPOINTSERVICE_WSDL_LOCATION = url;
        WEBSERVICEENPOINTSERVICE_EXCEPTION = e;
    }

    public WebServiceEnpointService() {
        super(__getWsdlLocation(), WEBSERVICEENPOINTSERVICE_QNAME);
    }

    public WebServiceEnpointService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEENPOINTSERVICE_QNAME, features);
    }

    public WebServiceEnpointService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEENPOINTSERVICE_QNAME);
    }

    public WebServiceEnpointService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEENPOINTSERVICE_QNAME, features);
    }

    public WebServiceEnpointService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceEnpointService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns IWebServiceEnpoint
     */
    @WebEndpoint(name = "WebServiceEnpointPort")
    public IWebServiceEnpoint getWebServiceEnpointPort() {
        return super.getPort(new QName("http://enpoint.WebService.web.shen0d.cc/", "WebServiceEnpointPort"), IWebServiceEnpoint.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IWebServiceEnpoint
     */
    @WebEndpoint(name = "WebServiceEnpointPort")
    public IWebServiceEnpoint getWebServiceEnpointPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://enpoint.WebService.web.shen0d.cc/", "WebServiceEnpointPort"), IWebServiceEnpoint.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEENPOINTSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEENPOINTSERVICE_EXCEPTION;
        }
        return WEBSERVICEENPOINTSERVICE_WSDL_LOCATION;
    }

}
