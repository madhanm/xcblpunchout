//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.10.18 at 05:46:33 PM IST 
//


package com.cxmlpunchout.sebo.cxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &lt;element ref="{}CRLRefs" minOccurs="0"/>
 *         &lt;element ref="{}OCSPRefs" minOccurs="0"/>
 *         &lt;element ref="{}OtherRefs" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Id" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "crlRefs",
    "ocspRefs",
    "otherRefs"
})
@XmlRootElement(name = "AttributeRevocationRefs")
public class AttributeRevocationRefs {

    @XmlElement(name = "CRLRefs")
    protected CRLRefs crlRefs;
    @XmlElement(name = "OCSPRefs")
    protected OCSPRefs ocspRefs;
    @XmlElement(name = "OtherRefs")
    protected OtherRefs otherRefs;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the crlRefs property.
     * 
     * @return
     *     possible object is
     *     {@link CRLRefs }
     *     
     */
    public CRLRefs getCRLRefs() {
        return crlRefs;
    }

    /**
     * Sets the value of the crlRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRLRefs }
     *     
     */
    public void setCRLRefs(CRLRefs value) {
        this.crlRefs = value;
    }

    /**
     * Gets the value of the ocspRefs property.
     * 
     * @return
     *     possible object is
     *     {@link OCSPRefs }
     *     
     */
    public OCSPRefs getOCSPRefs() {
        return ocspRefs;
    }

    /**
     * Sets the value of the ocspRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link OCSPRefs }
     *     
     */
    public void setOCSPRefs(OCSPRefs value) {
        this.ocspRefs = value;
    }

    /**
     * Gets the value of the otherRefs property.
     * 
     * @return
     *     possible object is
     *     {@link OtherRefs }
     *     
     */
    public OtherRefs getOtherRefs() {
        return otherRefs;
    }

    /**
     * Sets the value of the otherRefs property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherRefs }
     *     
     */
    public void setOtherRefs(OtherRefs value) {
        this.otherRefs = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}