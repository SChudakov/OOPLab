//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.11.25 at 07:26:59 PM EET 
//


package com.sschudakov.xml.bin;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for event complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="event">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="last_first_middle_name" type="{sschudakov}last_first_middle_name"/>
 *         &lt;element name="faculty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sub-faculty" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="branch-of-study" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="time" type="{sschudakov}time"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "event", propOrder = {
    "lastFirstMiddleName",
    "faculty",
    "subFaculty",
    "branchOfStudy",
    "time"
})
public class Event {

    @XmlElement(name = "last_first_middle_name", required = true)
    protected LastFirstMiddleName lastFirstMiddleName;
    @XmlElement(required = true)
    protected String faculty;
    @XmlElement(name = "sub-faculty", required = true)
    protected String subFaculty;
    @XmlElement(name = "branch-of-study", required = true)
    protected String branchOfStudy;
    @XmlElement(required = true)
    protected Time time;

    public Event() {
    }

    public Event(LastFirstMiddleName lastFirstMiddleName, String faculty, String subFaculty, String branchOfStudy, Time time) {
        this.lastFirstMiddleName = lastFirstMiddleName;
        this.faculty = faculty;
        this.subFaculty = subFaculty;
        this.branchOfStudy = branchOfStudy;
        this.time = time;
    }

    /**
     * Gets the value of the lastFirstMiddleName property.
     * 
     * @return
     *     possible object is
     *     {@link LastFirstMiddleName }
     *     
     */
    public LastFirstMiddleName getLastFirstMiddleName() {
        return lastFirstMiddleName;
    }

    /**
     * Sets the value of the lastFirstMiddleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link LastFirstMiddleName }
     *     
     */
    public void setLastFirstMiddleName(LastFirstMiddleName value) {
        this.lastFirstMiddleName = value;
    }

    /**
     * Gets the value of the faculty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * Sets the value of the faculty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaculty(String value) {
        this.faculty = value;
    }

    /**
     * Gets the value of the subFaculty property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubFaculty() {
        return subFaculty;
    }

    /**
     * Sets the value of the subFaculty property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubFaculty(String value) {
        this.subFaculty = value;
    }

    /**
     * Gets the value of the branchOfStudy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchOfStudy() {
        return branchOfStudy;
    }

    /**
     * Sets the value of the branchOfStudy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchOfStudy(String value) {
        this.branchOfStudy = value;
    }

    /**
     * Gets the value of the time property.
     * 
     * @return
     *     possible object is
     *     {@link Time }
     *     
     */
    public Time getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     * 
     * @param value
     *     allowed object is
     *     {@link Time }
     *     
     */
    public void setTime(Time value) {
        this.time = value;
    }

    @Override
    public String toString() {
        return "{\n" +
                "last_first_middle_name: " + this.lastFirstMiddleName + ",\n" +
                "faculty: " + this.faculty + ",\n" +
                "sub-faculty: " + this.subFaculty + ",\n" +
                "branchOfStudy: " + this.branchOfStudy + ",\n" +
                "time: " + this.time + "\n" +
                "}";
    }
}
