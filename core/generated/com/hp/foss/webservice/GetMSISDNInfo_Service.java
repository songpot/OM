
/*
 * 
 */

package com.hp.foss.webservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.3.3
 * 2018-09-19T10:56:32.898+07:00
 * Generated source version: 2.3.3
 * 
 */


@WebServiceClient(name = "GetMSISDNInfo", 
                  wsdlLocation = "file:/D:/WorkSpace/TOT/FlowOne/OM/core/wsdl/SIMM/getmsisdninfo/GetMSISDNInfo_1.wsdl",
                  targetNamespace = "http://webservice.foss.hp.com") 
public class GetMSISDNInfo_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webservice.foss.hp.com", "GetMSISDNInfo");
    public final static QName GetMSISDNInfoPort = new QName("http://webservice.foss.hp.com", "GetMSISDNInfoPort");
    static {
        URL url = null;
        try {
            url = new URL("file:/D:/WorkSpace/TOT/FlowOne/OM/core/wsdl/SIMM/getmsisdninfo/GetMSISDNInfo_1.wsdl");
        } catch (MalformedURLException e) {
            System.err.println("Can not initialize the default wsdl from file:/D:/WorkSpace/TOT/FlowOne/OM/core/wsdl/SIMM/getmsisdninfo/GetMSISDNInfo_1.wsdl");
            // e.printStackTrace();
        }
        WSDL_LOCATION = url;
    }

    public GetMSISDNInfo_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public GetMSISDNInfo_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GetMSISDNInfo_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public GetMSISDNInfo_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public GetMSISDNInfo_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public GetMSISDNInfo_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GetMSISDNInfoService
     */
    @WebEndpoint(name = "GetMSISDNInfoPort")
    public GetMSISDNInfoService getGetMSISDNInfoPort() {
        return super.getPort(GetMSISDNInfoPort, GetMSISDNInfoService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GetMSISDNInfoService
     */
    @WebEndpoint(name = "GetMSISDNInfoPort")
    public GetMSISDNInfoService getGetMSISDNInfoPort(WebServiceFeature... features) {
        return super.getPort(GetMSISDNInfoPort, GetMSISDNInfoService.class, features);
    }

}
