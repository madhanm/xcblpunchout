//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.18 at 05:46:33 PM IST 
//


package com.cxmlpunchout.sebo.cxml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
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
 *       &lt;choice>
 *         &lt;choice maxOccurs="unbounded">
 *           &lt;element ref="{}X509IssuerSerial"/>
 *           &lt;element ref="{}X509SKI"/>
 *           &lt;element ref="{}X509SubjectName"/>
 *           &lt;element ref="{}X509Certificate"/>
 *         &lt;/choice>
 *         &lt;element ref="{}X509CRL"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "x509IssuerSerialOrX509SKIOrX509SubjectName",
    "x509CRL"
})
@XmlRootElement(name = "X509Data")
public class X509Data {

    @XmlElementRefs({
        @XmlElementRef(name = "X509SubjectName", type = JAXBElement.class),
        @XmlElementRef(name = "X509IssuerSerial", type = X509IssuerSerial.class),
        @XmlElementRef(name = "X509Certificate", type = JAXBElement.class),
        @XmlElementRef(name = "X509SKI", type = JAXBElement.class)
    })
    protected List<java.lang.Object> x509IssuerSerialOrX509SKIOrX509SubjectName;
    @XmlElement(name = "X509CRL")
    protected String x509CRL;

    /**
     * Gets the value of the x509IssuerSerialOrX509SKIOrX509SubjectName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the x509IssuerSerialOrX509SKIOrX509SubjectName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getX509IssuerSerialOrX509SKIOrX509SubjectName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link X509IssuerSerial }
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<java.lang.Object> getX509IssuerSerialOrX509SKIOrX509SubjectName() {
        if (x509IssuerSerialOrX509SKIOrX509SubjectName == null) {
            x509IssuerSerialOrX509SKIOrX509SubjectName = new ArrayList<java.lang.Object>();
        }
        return this.x509IssuerSerialOrX509SKIOrX509SubjectName;
    }

    /**
     * Gets the value of the x509CRL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX509CRL() {
        return x509CRL;
    }

    /**
     * Sets the value of the x509CRL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX509CRL(String value) {
        this.x509CRL = value;
    }

}