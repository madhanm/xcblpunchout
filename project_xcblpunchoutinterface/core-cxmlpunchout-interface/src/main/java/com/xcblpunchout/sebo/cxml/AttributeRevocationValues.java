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
 *         &lt;element ref="{}CRLValues" minOccurs="0"/>
 *         &lt;element ref="{}OCSPValues" minOccurs="0"/>
 *         &lt;element ref="{}OtherValues" minOccurs="0"/>
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
    "crlValues",
    "ocspValues",
    "otherValues"
})
@XmlRootElement(name = "AttributeRevocationValues")
public class AttributeRevocationValues {

    @XmlElement(name = "CRLValues")
    protected CRLValues crlValues;
    @XmlElement(name = "OCSPValues")
    protected OCSPValues ocspValues;
    @XmlElement(name = "OtherValues")
    protected OtherValues otherValues;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the crlValues property.
     * 
     * @return
     *     possible object is
     *     {@link CRLValues }
     *     
     */
    public CRLValues getCRLValues() {
        return crlValues;
    }

    /**
     * Sets the value of the crlValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link CRLValues }
     *     
     */
    public void setCRLValues(CRLValues value) {
        this.crlValues = value;
    }

    /**
     * Gets the value of the ocspValues property.
     * 
     * @return
     *     possible object is
     *     {@link OCSPValues }
     *     
     */
    public OCSPValues getOCSPValues() {
        return ocspValues;
    }

    /**
     * Sets the value of the ocspValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link OCSPValues }
     *     
     */
    public void setOCSPValues(OCSPValues value) {
        this.ocspValues = value;
    }

    /**
     * Gets the value of the otherValues property.
     * 
     * @return
     *     possible object is
     *     {@link OtherValues }
     *     
     */
    public OtherValues getOtherValues() {
        return otherValues;
    }

    /**
     * Sets the value of the otherValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link OtherValues }
     *     
     */
    public void setOtherValues(OtherValues value) {
        this.otherValues = value;
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
