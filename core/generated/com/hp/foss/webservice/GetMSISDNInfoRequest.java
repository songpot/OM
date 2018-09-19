
package com.hp.foss.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMSISDNInfoRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMSISDNInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getMSISDNInfo" type="{http://webservice.foss.hp.com}getMSISDNInfoRequestData" minOccurs="0"/>
 *         &lt;element name="headerData" type="{http://webservice.foss.hp.com}headerRequestData" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMSISDNInfoRequest", propOrder = {
    "getMSISDNInfo",
    "headerData"
})
public class GetMSISDNInfoRequest {

    protected GetMSISDNInfoRequestData getMSISDNInfo;
    protected HeaderRequestData headerData;

    /**
     * Gets the value of the getMSISDNInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GetMSISDNInfoRequestData }
     *     
     */
    public GetMSISDNInfoRequestData getGetMSISDNInfo() {
        return getMSISDNInfo;
    }

    /**
     * Sets the value of the getMSISDNInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetMSISDNInfoRequestData }
     *     
     */
    public void setGetMSISDNInfo(GetMSISDNInfoRequestData value) {
        this.getMSISDNInfo = value;
    }

    /**
     * Gets the value of the headerData property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderRequestData }
     *     
     */
    public HeaderRequestData getHeaderData() {
        return headerData;
    }

    /**
     * Sets the value of the headerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderRequestData }
     *     
     */
    public void setHeaderData(HeaderRequestData value) {
        this.headerData = value;
    }

}
