package com.hp.foss.webservice;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.3.3
 * 2018-09-19T10:56:32.868+07:00
 * Generated source version: 2.3.3
 * 
 */
 
@WebService(targetNamespace = "http://webservice.foss.hp.com", name = "GetMSISDNInfoService")
@XmlSeeAlso({ObjectFactory.class})
public interface GetMSISDNInfoService {

    @WebMethod
    @RequestWrapper(localName = "getMSISDNInfo", targetNamespace = "http://webservice.foss.hp.com", className = "com.hp.foss.webservice.GetMSISDNInfo")
    @ResponseWrapper(localName = "getMSISDNInfoResponse", targetNamespace = "http://webservice.foss.hp.com", className = "com.hp.foss.webservice.GetMSISDNInfoResponse")
    @WebResult(name = "return", targetNamespace = "")
    public com.hp.foss.webservice.GetMSISDNInfoResponseData getMSISDNInfo(
        @WebParam(name = "RequestData", targetNamespace = "")
        com.hp.foss.webservice.GetMSISDNInfoRequest requestData
    );
}
