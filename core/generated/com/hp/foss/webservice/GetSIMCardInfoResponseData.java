
package com.hp.foss.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSIMCardInfoResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSIMCardInfoResponseData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="algorithm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="function_set_indicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="headerData" type="{http://webservice.foss.hp.com}headerResponseData" minOccurs="0"/>
 *         &lt;element name="iccid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="imsi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ki" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="msisdn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ota" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pin1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="pin2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puk1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="puk2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="service_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sim_type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="transport_key" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSIMCardInfoResponseData", propOrder = {
    "algorithm",
    "functionSetIndicator",
    "headerData",
    "iccid",
    "imsi",
    "ki",
    "msisdn",
    "ota",
    "pin1",
    "pin2",
    "puk1",
    "puk2",
    "serviceType",
    "simType",
    "transportKey"
})
public class GetSIMCardInfoResponseData {

    protected String algorithm;
    @XmlElement(name = "function_set_indicator")
    protected String functionSetIndicator;
    protected HeaderResponseData headerData;
    protected String iccid;
    protected String imsi;
    protected String ki;
    protected String msisdn;
    protected String ota;
    protected String pin1;
    protected String pin2;
    protected String puk1;
    protected String puk2;
    @XmlElement(name = "service_type")
    protected String serviceType;
    @XmlElement(name = "sim_type")
    protected String simType;
    @XmlElement(name = "transport_key")
    protected String transportKey;

    /**
     * Gets the value of the algorithm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Sets the value of the algorithm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

    /**
     * Gets the value of the functionSetIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFunctionSetIndicator() {
        return functionSetIndicator;
    }

    /**
     * Sets the value of the functionSetIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFunctionSetIndicator(String value) {
        this.functionSetIndicator = value;
    }

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
     * Gets the value of the iccid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIccid() {
        return iccid;
    }

    /**
     * Sets the value of the iccid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIccid(String value) {
        this.iccid = value;
    }

    /**
     * Gets the value of the imsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImsi() {
        return imsi;
    }

    /**
     * Sets the value of the imsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImsi(String value) {
        this.imsi = value;
    }

    /**
     * Gets the value of the ki property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKi() {
        return ki;
    }

    /**
     * Sets the value of the ki property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKi(String value) {
        this.ki = value;
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
     * Gets the value of the ota property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOta() {
        return ota;
    }

    /**
     * Sets the value of the ota property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOta(String value) {
        this.ota = value;
    }

    /**
     * Gets the value of the pin1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin1() {
        return pin1;
    }

    /**
     * Sets the value of the pin1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin1(String value) {
        this.pin1 = value;
    }

    /**
     * Gets the value of the pin2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPin2() {
        return pin2;
    }

    /**
     * Sets the value of the pin2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPin2(String value) {
        this.pin2 = value;
    }

    /**
     * Gets the value of the puk1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuk1() {
        return puk1;
    }

    /**
     * Sets the value of the puk1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuk1(String value) {
        this.puk1 = value;
    }

    /**
     * Gets the value of the puk2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPuk2() {
        return puk2;
    }

    /**
     * Sets the value of the puk2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPuk2(String value) {
        this.puk2 = value;
    }

    /**
     * Gets the value of the serviceType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceType() {
        return serviceType;
    }

    /**
     * Sets the value of the serviceType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceType(String value) {
        this.serviceType = value;
    }

    /**
     * Gets the value of the simType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSimType() {
        return simType;
    }

    /**
     * Sets the value of the simType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSimType(String value) {
        this.simType = value;
    }

    /**
     * Gets the value of the transportKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransportKey() {
        return transportKey;
    }

    /**
     * Sets the value of the transportKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransportKey(String value) {
        this.transportKey = value;
    }

}
