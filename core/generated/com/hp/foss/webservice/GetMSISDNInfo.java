
package com.hp.foss.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMSISDNInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMSISDNInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestData" type="{http://webservice.foss.hp.com}getMSISDNInfoRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMSISDNInfo", propOrder = {
    "requestData"
})
public class GetMSISDNInfo {

    @XmlElement(name = "RequestData")
    protected GetMSISDNInfoRequest requestData;

    /**
     * Gets the value of the requestData property.
     * 
     * @return
     *     possible object is
     *     {@link GetMSISDNInfoRequest }
     *     
     */
    public GetMSISDNInfoRequest getRequestData() {
        return requestData;
    }

    /**
     * Sets the value of the requestData property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMSISDNInfoRequest }
     *     
     */
    public void setRequestData(GetMSISDNInfoRequest value) {
        this.requestData = value;
    }

}
