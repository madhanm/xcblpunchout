//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.18 at 05:46:33 PM IST 
//


package com.cxmlpunchout.sebo.cxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}Accounting"/>
 *         &lt;element ref="{}Charge"/>
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
    "accounting",
    "charge"
})
@XmlRootElement(name = "Distribution")
public class Distribution {

    @XmlElement(name = "Accounting", required = true)
    protected Accounting accounting;
    @XmlElement(name = "Charge", required = true)
    protected MoneyElement charge;

    /**
     * Gets the value of the accounting property.
     * 
     * @return
     *     possible object is
     *     {@link Accounting }
     *     
     */
    public Accounting getAccounting() {
        return accounting;
    }

    /**
     * Sets the value of the accounting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Accounting }
     *     
     */
    public void setAccounting(Accounting value) {
        this.accounting = value;
    }

    /**
     * Gets the value of the charge property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getCharge() {
        return charge;
    }

    /**
     * Sets the value of the charge property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setCharge(MoneyElement value) {
        this.charge = value;
    }

}