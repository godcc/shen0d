
package cc.shen0d.web.WebService.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the cc.shen0d.web.WebService.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWebServiceTestResponse_QNAME = new QName("http://enpoint.WebService.web.shen0d.cc/", "getWebServiceTestResponse");
    private final static QName _GetWebServiceTest_QNAME = new QName("http://enpoint.WebService.web.shen0d.cc/", "getWebServiceTest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: cc.shen0d.web.WebService.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetWebServiceTest }
     * 
     */
    public GetWebServiceTest createGetWebServiceTest() {
        return new GetWebServiceTest();
    }

    /**
     * Create an instance of {@link GetWebServiceTestResponse }
     * 
     */
    public GetWebServiceTestResponse createGetWebServiceTestResponse() {
        return new GetWebServiceTestResponse();
    }

    /**
     * Create an instance of {@link WebServiceTest }
     * 
     */
    public WebServiceTest createWebServiceTest() {
        return new WebServiceTest();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebServiceTestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enpoint.WebService.web.shen0d.cc/", name = "getWebServiceTestResponse")
    public JAXBElement<GetWebServiceTestResponse> createGetWebServiceTestResponse(GetWebServiceTestResponse value) {
        return new JAXBElement<GetWebServiceTestResponse>(_GetWebServiceTestResponse_QNAME, GetWebServiceTestResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWebServiceTest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enpoint.WebService.web.shen0d.cc/", name = "getWebServiceTest")
    public JAXBElement<GetWebServiceTest> createGetWebServiceTest(GetWebServiceTest value) {
        return new JAXBElement<GetWebServiceTest>(_GetWebServiceTest_QNAME, GetWebServiceTest.class, null, value);
    }

}
