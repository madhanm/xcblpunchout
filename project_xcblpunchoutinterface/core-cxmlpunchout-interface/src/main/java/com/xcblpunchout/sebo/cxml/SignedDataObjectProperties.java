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
 *         &lt;element ref="{}DataObjectFormat" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}CommitmentTypeIndication" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}AllDataObjectsTimeStamp" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{}IndividualDataObjectsTimeStamp" maxOccurs="unbounded" minOccurs="0"/>
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
    "dataObjectFormat",
    "commitmentTypeIndication",
    "allDataObjectsTimeStamp",
    "individualDataObjectsTimeStamp"
})
@XmlRootElement(name = "SignedDataObjectProperties")
public class SignedDataObjectProperties {

    @XmlElement(name = "DataObjectFormat")
    protected List<DataObjectFormat> dataObjectFormat;
    @XmlElement(name = "CommitmentTypeIndication")
    protected List<CommitmentTypeIndication> commitmentTypeIndication;
    @XmlElement(name = "AllDataObjectsTimeStamp")
    protected List<AllDataObjectsTimeStamp> allDataObjectsTimeStamp;
    @XmlElement(name = "IndividualDataObjectsTimeStamp")
    protected List<IndividualDataObjectsTimeStamp> individualDataObjectsTimeStamp;
    @XmlAttribute(name = "Id")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;

    /**
     * Gets the value of the dataObjectFormat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dataObjectFormat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDataObjectFormat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataObjectFormat }
     * 
     * 
     */
    public List<DataObjectFormat> getDataObjectFormat() {
        if (dataObjectFormat == null) {
            dataObjectFormat = new ArrayList<DataObjectFormat>();
        }
        return this.dataObjectFormat;
    }

    /**
     * Gets the value of the commitmentTypeIndication property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commitmentTypeIndication property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommitmentTypeIndication().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CommitmentTypeIndication }
     * 
     * 
     */
    public List<CommitmentTypeIndication> getCommitmentTypeIndication() {
        if (commitmentTypeIndication == null) {
            commitmentTypeIndication = new ArrayList<CommitmentTypeIndication>();
        }
        return this.commitmentTypeIndication;
    }

    /**
     * Gets the value of the allDataObjectsTimeStamp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the allDataObjectsTimeStamp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAllDataObjectsTimeStamp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AllDataObjectsTimeStamp }
     * 
     * 
     */
    public List<AllDataObjectsTimeStamp> getAllDataObjectsTimeStamp() {
        if (allDataObjectsTimeStamp == null) {
            allDataObjectsTimeStamp = new ArrayList<AllDataObjectsTimeStamp>();
        }
        return this.allDataObjectsTimeStamp;
    }

    /**
     * Gets the value of the individualDataObjectsTimeStamp property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the individualDataObjectsTimeStamp property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndividualDataObjectsTimeStamp().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndividualDataObjectsTimeStamp }
     * 
     * 
     */
    public List<IndividualDataObjectsTimeStamp> getIndividualDataObjectsTimeStamp() {
        if (individualDataObjectsTimeStamp == null) {
            individualDataObjectsTimeStamp = new ArrayList<IndividualDataObjectsTimeStamp>();
        }
        return this.individualDataObjectsTimeStamp;
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
