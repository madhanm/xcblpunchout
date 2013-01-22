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
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element ref="{}SourcingStatus" minOccurs="0"/>
 *         &lt;element ref="{}Total"/>
 *         &lt;element ref="{}ShipTo" minOccurs="0"/>
 *         &lt;element ref="{}Shipping" minOccurs="0"/>
 *         &lt;element ref="{}Tax" minOccurs="0"/>
 *         &lt;element ref="{}SupplierOrderInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="operationAllowed" use="required">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="create"/>
 *             &lt;enumeration value="inspect"/>
 *             &lt;enumeration value="edit"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="quoteStatus" default="final">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="pending"/>
 *             &lt;enumeration value="final"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sourcingStatus",
    "total",
    "shipTo",
    "shipping",
    "tax",
    "supplierOrderInfo"
})
@XmlRootElement(name = "PunchOutOrderMessageHeader")
public class PunchOutOrderMessageHeader {

    @XmlElement(name = "SourcingStatus")
    protected SourcingStatus sourcingStatus;
    @XmlElement(name = "Total", required = true)
    protected MoneyElement total;
    @XmlElement(name = "ShipTo")
    protected ShipTo shipTo;
    @XmlElement(name = "Shipping")
    protected Shipping shipping;
    @XmlElement(name = "Tax")
    protected Tax tax;
    @XmlElement(name = "SupplierOrderInfo")
    protected SupplierOrderInfo supplierOrderInfo;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String operationAllowed;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String quoteStatus;

    /**
     * Gets the value of the sourcingStatus property.
     * 
     * @return
     *     possible object is
     *     {@link SourcingStatus }
     *     
     */
    public SourcingStatus getSourcingStatus() {
        return sourcingStatus;
    }

    /**
     * Sets the value of the sourcingStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourcingStatus }
     *     
     */
    public void setSourcingStatus(SourcingStatus value) {
        this.sourcingStatus = value;
    }

    /**
     * Gets the value of the total property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getTotal() {
        return total;
    }

    /**
     * Sets the value of the total property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setTotal(MoneyElement value) {
        this.total = value;
    }

    /**
     * Gets the value of the shipTo property.
     * 
     * @return
     *     possible object is
     *     {@link ShipTo }
     *     
     */
    public ShipTo getShipTo() {
        return shipTo;
    }

    /**
     * Sets the value of the shipTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShipTo }
     *     
     */
    public void setShipTo(ShipTo value) {
        this.shipTo = value;
    }

    /**
     * Gets the value of the shipping property.
     * 
     * @return
     *     possible object is
     *     {@link Shipping }
     *     
     */
    public Shipping getShipping() {
        return shipping;
    }

    /**
     * Sets the value of the shipping property.
     * 
     * @param value
     *     allowed object is
     *     {@link Shipping }
     *     
     */
    public void setShipping(Shipping value) {
        this.shipping = value;
    }

    /**
     * Gets the value of the tax property.
     * 
     * @return
     *     possible object is
     *     {@link Tax }
     *     
     */
    public Tax getTax() {
        return tax;
    }

    /**
     * Sets the value of the tax property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tax }
     *     
     */
    public void setTax(Tax value) {
        this.tax = value;
    }

    /**
     * Gets the value of the supplierOrderInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierOrderInfo }
     *     
     */
    public SupplierOrderInfo getSupplierOrderInfo() {
        return supplierOrderInfo;
    }

    /**
     * Sets the value of the supplierOrderInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierOrderInfo }
     *     
     */
    public void setSupplierOrderInfo(SupplierOrderInfo value) {
        this.supplierOrderInfo = value;
    }

    /**
     * Gets the value of the operationAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperationAllowed() {
        return operationAllowed;
    }

    /**
     * Sets the value of the operationAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperationAllowed(String value) {
        this.operationAllowed = value;
    }

    /**
     * Gets the value of the quoteStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuoteStatus() {
        if (quoteStatus == null) {
            return "final";
        } else {
            return quoteStatus;
        }
    }

    /**
     * Sets the value of the quoteStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuoteStatus(String value) {
        this.quoteStatus = value;
    }

}