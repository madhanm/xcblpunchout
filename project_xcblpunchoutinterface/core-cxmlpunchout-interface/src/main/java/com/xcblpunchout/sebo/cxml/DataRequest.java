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
 *         &lt;element ref="{}InternalID"/>
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
    "internalID"
})
public class DataRequest {

    @XmlElement(name = "InternalID", required = true)
    protected InternalID internalID;

    /**
     * Gets the value of the internalID property.
     * 
     * @return
     *     possible object is
     *     {@link InternalID }
     *     
     */
    public InternalID getInternalID() {
        return internalID;
    }

    /**
     * Sets the value of the internalID property.
     * 
     * @param value
     *     allowed object is
     *     {@link InternalID }
     *     
     */
    public void setInternalID(InternalID value) {
        this.internalID = value;
    }

}
