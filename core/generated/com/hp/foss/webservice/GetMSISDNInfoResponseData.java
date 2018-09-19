
package com.hp.foss.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getMSISDNInfoResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getMSISDNInfoResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="headerData" type="{http://webservice.foss.hp.com}headerResponseData" minOccurs="0"/>
 *         &lt;element name="msisd_info" type="{http://webservice.foss.hp.com}msisdnInfo" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vanity_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getMSISDNInfoResponseData", propOrder = {
    "headerData",
    "msisdInfo",
    "msisdn",
    "status",
    "vanityType"
})
public class GetMSISDNInfoResponseData {

    protected HeaderResponseData headerData;
    @XmlElement(name = "msisd_info")
    protected MsisdnInfo msisdInfo;
    protected String msisdn;
    protected String status;
    @XmlElement(name = "vanity_type")
    protected String vanityType;

    /**
     * Gets the value of the headerData property.
     * 
     * @return
     *     possible object is
     *     {@link HeaderResponseData }
     *     
     */
    public HeaderResponseData getHeaderData() {
        return headerData;
    }

    /**
     * Sets the value of the headerData property.
     * 
     * @param value
     *     allowed object is
     *     {@link HeaderResponseData }
     *     
     */
    public void setHeaderData(HeaderResponseData value) {
        this.headerData = value;
    }

    /**
     * Gets the value of the msisdInfo property.
     * 
     * @return
     *     possible object is
     *     {@link MsisdnInfo }
     *     
     */
    public MsisdnInfo getMsisdInfo() {
        return msisdInfo;
    }

    /**
     * Sets the value of the msisdInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link MsisdnInfo }
     *     
     */
    public void setMsisdInfo(MsisdnInfo value) {
        this.msisdInfo = value;
    }

    /**
     * Gets the value of the msisdn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsisdn() {
        return msisdn;
    }

    /**
     * Sets the value of the msisdn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsisdn(String value) {
        this.msisdn = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the vanityType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVanityType() {
        return vanityType;
    }

    /**
     * Sets the value of the vanityType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVanityType(String value) {
        this.vanityType = value;
    }

}
