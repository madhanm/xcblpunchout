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
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}MaxAmount" minOccurs="0"/>
 *         &lt;element ref="{}MinAmount" minOccurs="0"/>
 *         &lt;element ref="{}MaxReleaseAmount" minOccurs="0"/>
 *         &lt;element ref="{}MinReleaseAmount" minOccurs="0"/>
 *         &lt;element ref="{}Contact" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}Comments" minOccurs="0"/>
 *         &lt;element ref="{}DocumentReference" minOccurs="0"/>
 *         &lt;element ref="{}Extrinsic" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="agreementID" use="required" type="{}string" />
 *       &lt;attribute name="agreementDate" use="required" type="{}datetime.tz" />
 *       &lt;attribute name="type" default="value">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="value"/>
 *             &lt;enumeration value="quantity"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="effectiveDate" use="required" type="{}datetime.tz" />
 *       &lt;attribute name="expirationDate" use="required" type="{}datetime.tz" />
 *       &lt;attribute name="parentAgreementPayloadID" type="{}string" />
 *       &lt;attribute name="operation" default="new">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}token">
 *             &lt;enumeration value="new"/>
 *             &lt;enumeration value="update"/>
 *             &lt;enumeration value="delete"/>
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
    "maxAmount",
    "minAmount",
    "maxReleaseAmount",
    "minReleaseAmount",
    "contact",
    "comments",
    "documentReference",
    "extrinsic"
})
@XmlRootElement(name = "MasterAgreementRequestHeader")
public class MasterAgreementRequestHeader {

    @XmlElement(name = "MaxAmount")
    protected MoneyElement maxAmount;
    @XmlElement(name = "MinAmount")
    protected MoneyElement minAmount;
    @XmlElement(name = "MaxReleaseAmount")
    protected MoneyElement maxReleaseAmount;
    @XmlElement(name = "MinReleaseAmount")
    protected MoneyElement minReleaseAmount;
    @XmlElement(name = "Contact")
    protected List<Contact> contact;
    @XmlElement(name = "Comments")
    protected Comments comments;
    @XmlElement(name = "DocumentReference")
    protected DocumentReference documentReference;
    @XmlElement(name = "Extrinsic")
    protected List<Extrinsic> extrinsic;
    @XmlAttribute(required = true)
    protected String agreementID;
    @XmlAttribute(required = true)
    protected String agreementDate;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;
    @XmlAttribute(required = true)
    protected String effectiveDate;
    @XmlAttribute(required = true)
    protected String expirationDate;
    @XmlAttribute
    protected String parentAgreementPayloadID;
    @XmlAttribute
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String operation;

    /**
     * Gets the value of the maxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getMaxAmount() {
        return maxAmount;
    }

    /**
     * Sets the value of the maxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setMaxAmount(MoneyElement value) {
        this.maxAmount = value;
    }

    /**
     * Gets the value of the minAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getMinAmount() {
        return minAmount;
    }

    /**
     * Sets the value of the minAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setMinAmount(MoneyElement value) {
        this.minAmount = value;
    }

    /**
     * Gets the value of the maxReleaseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getMaxReleaseAmount() {
        return maxReleaseAmount;
    }

    /**
     * Sets the value of the maxReleaseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setMaxReleaseAmount(MoneyElement value) {
        this.maxReleaseAmount = value;
    }

    /**
     * Gets the value of the minReleaseAmount property.
     * 
     * @return
     *     possible object is
     *     {@link MoneyElement }
     *     
     */
    public MoneyElement getMinReleaseAmount() {
        return minReleaseAmount;
    }

    /**
     * Sets the value of the minReleaseAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link MoneyElement }
     *     
     */
    public void setMinReleaseAmount(MoneyElement value) {
        this.minReleaseAmount = value;
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
     * Gets the value of the documentReference property.
     * 
     * @return
     *     possible object is
     *     {@link DocumentReference }
     *     
     */
    public DocumentReference getDocumentReference() {
        return documentReference;
    }

    /**
     * Sets the value of the documentReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocumentReference }
     *     
     */
    public void setDocumentReference(DocumentReference value) {
        this.documentReference = value;
    }

    /**
     * Gets the value of the extrinsic property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the extrinsic property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExtrinsic().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Extrinsic }
     * 
     * 
     */
    public List<Extrinsic> getExtrinsic() {
        if (extrinsic == null) {
            extrinsic = new ArrayList<Extrinsic>();
        }
        return this.extrinsic;
    }

    /**
     * Gets the value of the agreementID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementID() {
        return agreementID;
    }

    /**
     * Sets the value of the agreementID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementID(String value) {
        this.agreementID = value;
    }

    /**
     * Gets the value of the agreementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgreementDate() {
        return agreementDate;
    }

    /**
     * Sets the value of the agreementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgreementDate(String value) {
        this.agreementDate = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        if (type == null) {
            return "value";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expirationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Sets the value of the expirationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpirationDate(String value) {
        this.expirationDate = value;
    }

    /**
     * Gets the value of the parentAgreementPayloadID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentAgreementPayloadID() {
        return parentAgreementPayloadID;
    }

    /**
     * Sets the value of the parentAgreementPayloadID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentAgreementPayloadID(String value) {
        this.parentAgreementPayloadID = value;
    }

    /**
     * Gets the value of the operation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperation() {
        if (operation == null) {
            return "new";
        } else {
            return operation;
        }
    }

    /**
     * Sets the value of the operation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperation(String value) {
        this.operation = value;
    }

}
