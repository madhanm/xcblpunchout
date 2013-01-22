//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.18 at 05:46:33 PM IST 
//


package com.cxmlpunchout.sebo.cxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}MasterAgreementRequestHeader"/>
 *         &lt;element ref="{}AgreementItemOut" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "masterAgreementRequestHeader",
    "agreementItemOut"
})
public class MasterAgreementRequest {

    @XmlElement(name = "MasterAgreementRequestHeader", required = true)
    protected MasterAgreementRequestHeader masterAgreementRequestHeader;
    @XmlElement(name = "AgreementItemOut")
    protected List<AgreementItemOut> agreementItemOut;

    /**
     * Gets the value of the masterAgreementRequestHeader property.
     * 
     * @return
     *     possible object is
     *     {@link MasterAgreementRequestHeader }
     *     
     */
    public MasterAgreementRequestHeader getMasterAgreementRequestHeader() {
        return masterAgreementRequestHeader;
    }

    /**
     * Sets the value of the masterAgreementRequestHeader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MasterAgreementRequestHeader }
     *     
     */
    public void setMasterAgreementRequestHeader(MasterAgreementRequestHeader value) {
        this.masterAgreementRequestHeader = value;
    }

    /**
     * Gets the value of the agreementItemOut property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the agreementItemOut property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAgreementItemOut().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AgreementItemOut }
     * 
     * 
     */
    public List<AgreementItemOut> getAgreementItemOut() {
        if (agreementItemOut == null) {
            agreementItemOut = new ArrayList<AgreementItemOut>();
        }
        return this.agreementItemOut;
    }

}
