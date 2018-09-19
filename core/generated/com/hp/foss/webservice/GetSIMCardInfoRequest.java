
package com.hp.foss.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSIMCardInfoRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSIMCardInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getSIMCardInfo" type="{http://webservice.foss.hp.com}getSIMCardInfoRequestData" minOccurs="0"/>
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
@XmlType(name = "getSIMCardInfoRequest", propOrder = {
    "getSIMCardInfo",
    "headerData"
})
public class GetSIMCardInfoRequest {

    protected GetSIMCardInfoRequestData getSIMCardInfo;
    protected HeaderRequestData headerData;

    /**
     * Gets the value of the getSIMCardInfo property.
     * 
     * @return
     *     possible object is
     *     {@link GetSIMCardInfoRequestData }
     *     
     */
    public GetSIMCardInfoRequestData getGetSIMCardInfo() {
        return getSIMCardInfo;
    }

    /**
     * Sets the value of the getSIMCardInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetSIMCardInfoRequestData }
     *     
     */
    public void setGetSIMCardInfo(GetSIMCardInfoRequestData value) {
        this.getSIMCardInfo = value;
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
