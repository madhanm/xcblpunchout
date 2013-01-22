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
 *     &lt;extension base="{}ItemID.element">
 *       &lt;sequence>
 *         &lt;element ref="{}Path" minOccurs="0"/>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{}ItemDetail"/>
 *           &lt;element ref="{}BlanketItemDetail"/>
 *         &lt;/choice>
 *         &lt;choice minOccurs="0">
 *           &lt;element ref="{}SupplierID"/>
 *           &lt;element ref="{}SupplierList"/>
 *         &lt;/choice>
 *         &lt;element ref="{}ShipTo" minOccurs="0"/>
 *         &lt;element ref="{}Shipping" minOccurs="0"/>
 *         &lt;element ref="{}Tax" minOccurs="0"/>
 *         &lt;element ref="{}SpendDetail" minOccurs="0"/>
 *         &lt;element ref="{}Distribution" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Contact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Comments" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="quantity" use="required" type="{}r8" />
 *       &lt;attribute name="lineNumber" type="{}uint" />
 *       &lt;attribute name="requisitionID" type="{}string" />
 *       &lt;attribute name="agreementItemNumber" type="{}string" />
 *       &lt;attribute name="requestedDeliveryDate" type="{}date" />
 *       &lt;attribute name="isAdHoc">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="yes"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "path",
    "itemDetail",
    "blanketItemDetail",
    "supplierID",
    "supplierList",
    "shipTo",
    "shipping",
    "tax",
    "spendDetail",
    "distribution",
    "contact",
    "comments"
})
@XmlRootElement(name = "ItemOut")
public class ItemOut
    extends ItemIDElement
{

    @XmlElement(name = "Path")
    protected Path path;
    @XmlElement(name = "ItemDetail")
    protected ItemDetail itemDetail;
    @XmlElement(name = "BlanketItemDetail")
    protected BlanketItemDetail blanketItemDetail;
    @XmlElement(name = "SupplierID")
    protected SupplierID supplierID;
    @XmlElement(name = "SupplierList")
    protected SupplierList supplierList;
    @XmlElement(name = "ShipTo")
    protected ShipTo shipTo;
    @XmlElement(name = "Shipping")
    protected Shipping shipping;
    @XmlElement(name = "Tax")
    protected Tax tax;
    @XmlElement(name = "SpendDetail")
    protected SpendDetail spendDetail;
    @XmlElement(name = "Distribution")
    protected List<Distribution> distribution;
    @XmlElement(name = "Contact")
    protected List<Contact> contact;
    @XmlElement(name = "Comments")
    protected Comments comments;
    @XmlAttribute(required = true)
    protected String quantity;
    @XmlAttribute
    protected String lineNumber;
    @XmlAttribute
    protected String requisitionID;
    @XmlAttribute
    protected String agreementItemNumber;
    @XmlAttribute
    protected String requestedDeliveryDate;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String isAdHoc;

    /**
     * Gets the value of the path property.
     * 
     * @return
     *     possible object is
     *     {@link Path }
     *     
     */
    public Path getPath() {
        return path;
    }

    /**
     * Sets the value of the path property.
     * 
     * @param value
     *     allowed object is
     *     {@link Path }
     *     
     */
    public void setPath(Path value) {
        this.path = value;
    }

    /**
     * Gets the value of the itemDetail property.
     * 
     * @return
     *     possible object is
     *     {@link ItemDetail }
     *     
     */
    public ItemDetail getItemDetail() {
        return itemDetail;
    }

    /**
     * Sets the value of the itemDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link ItemDetail }
     *     
     */
    public void setItemDetail(ItemDetail value) {
        this.itemDetail = value;
    }

    /**
     * Gets the value of the blanketItemDetail property.
     * 
     * @return
     *     possible object is
     *     {@link BlanketItemDetail }
     *     
     */
    public BlanketItemDetail getBlanketItemDetail() {
        return blanketItemDetail;
    }

    /**
     * Sets the value of the blanketItemDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link BlanketItemDetail }
     *     
     */
    public void setBlanketItemDetail(BlanketItemDetail value) {
        this.blanketItemDetail = value;
    }

    /**
     * Gets the value of the supplierID property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierID }
     *     
     */
    public SupplierID getSupplierID() {
        return supplierID;
    }

    /**
     * Sets the value of the supplierID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierID }
     *     
     */
    public void setSupplierID(SupplierID value) {
        this.supplierID = value;
    }

    /**
     * Gets the value of the supplierList property.
     * 
     * @return
     *     possible object is
     *     {@link SupplierList }
     *     
     */
    public SupplierList getSupplierList() {
        return supplierList;
    }

    /**
     * Sets the value of the supplierList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupplierList }
     *     
     */
    public void setSupplierList(SupplierList value) {
        this.supplierList = value;
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
     * Gets the value of the spendDetail property.
     * 
     * @return
     *     possible object is
     *     {@link SpendDetail }
     *     
     */
    public SpendDetail getSpendDetail() {
        return spendDetail;
    }

    /**
     * Sets the value of the spendDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link SpendDetail }
     *     
     */
    public void setSpendDetail(SpendDetail value) {
        this.spendDetail = value;
    }

    /**
     * Gets the value of the distribution property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the distribution property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDistribution().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Distribution }
     * 
     * 
     */
    public List<Distribution> getDistribution() {
        if (distribution == null) {
            distribution = new ArrayList<Distribution>();
        }
        return this.distribution;
    }

    /**
     * Gets the value of the contact property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contact property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContact().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Contact }
     * 
     * 
     */
    public List<Contact> getContact() {
        if (contact == null) {
            contact = new ArrayList<Contact>();
        }
        return this.contact;
    }

    /**
     * Gets the value of the comments property.
     * 
     * @return
     *     possible object is
     *     {@link Comments }
     *     
     */
    public Comments getComments() {
        return comments;
    }

    /**
     * Sets the value of the comments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Comments }
     *     
     */
    public void setComments(Comments value) {
        this.comments = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQuantity(String value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the lineNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Sets the value of the lineNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLineNumber(String value) {
        this.lineNumber = value;
    }

    /**
     * Gets the value of the requisitionID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequisitionID() {
        return requisitionID;
    }

    /**
     * Sets the value of the requisitionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequisitionID(String value) {
        this.requisitionID = value;
    }

    /**
     * Gets the value of the agreementItemNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementItemNumber() {
        return agreementItemNumber;
    }

    /**
     * Sets the value of the agreementItemNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementItemNumber(String value) {
        this.agreementItemNumber = value;
    }

    /**
     * Gets the value of the requestedDeliveryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestedDeliveryDate() {
        return requestedDeliveryDate;
    }

    /**
     * Sets the value of the requestedDeliveryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestedDeliveryDate(String value) {
        this.requestedDeliveryDate = value;
    }

    /**
     * Gets the value of the isAdHoc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsAdHoc() {
        return isAdHoc;
    }

    /**
     * Sets the value of the isAdHoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsAdHoc(String value) {
        this.isAdHoc = value;
    }

}
