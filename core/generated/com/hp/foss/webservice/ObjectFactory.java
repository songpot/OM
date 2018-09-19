
package com.hp.foss.webservice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.hp.foss.webservice package. 
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

    private final static QName _GetSIMCardInfoResponse_QNAME = new QName("http://webservice.foss.hp.com", "getSIMCardInfoResponse");
    private final static QName _GetSIMCardInfo_QNAME = new QName("http://webservice.foss.hp.com", "getSIMCardInfo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.hp.foss.webservice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetSIMCardInfoResponseData }
     * 
     */
    public GetSIMCardInfoResponseData createGetSIMCardInfoResponseData() {
        return new GetSIMCardInfoResponseData();
    }

    /**
     * Create an instance of {@link GetSIMCardInfoRequest }
     * 
     */
    public GetSIMCardInfoRequest createGetSIMCardInfoRequest() {
        return new GetSIMCardInfoRequest();
    }

    /**
     * Create an instance of {@link HeaderRequestData }
     * 
     */
    public HeaderRequestData createHeaderRequestData() {
        return new HeaderRequestData();
    }

    /**
     * Create an instance of {@link GetSIMCardInfoRequestData }
     * 
     */
    public GetSIMCardInfoRequestData createGetSIMCardInfoRequestData() {
        return new GetSIMCardInfoRequestData();
    }

    /**
     * Create an instance of {@link GetSIMCardInfo }
     * 
     */
    public GetSIMCardInfo createGetSIMCardInfo() {
        return new GetSIMCardInfo();
    }

    /**
     * Create an instance of {@link HeaderResponseData }
     * 
     */
    public HeaderResponseData createHeaderResponseData() {
        return new HeaderResponseData();
    }

    /**
     * Create an instance of {@link GetSIMCardInfoResponse }
     * 
     */
    public GetSIMCardInfoResponse createGetSIMCardInfoResponse() {
        return new GetSIMCardInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSIMCardInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.foss.hp.com", name = "getSIMCardInfoResponse")
    public JAXBElement<GetSIMCardInfoResponse> createGetSIMCardInfoResponse(GetSIMCardInfoResponse value) {
        return new JAXBElement<GetSIMCardInfoResponse>(_GetSIMCardInfoResponse_QNAME, GetSIMCardInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetSIMCardInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservice.foss.hp.com", name = "getSIMCardInfo")
    public JAXBElement<GetSIMCardInfo> createGetSIMCardInfo(GetSIMCardInfo value) {
        return new JAXBElement<GetSIMCardInfo>(_GetSIMCardInfo_QNAME, GetSIMCardInfo.class, null, value);
    }

}
