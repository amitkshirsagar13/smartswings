//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.03 at 07:15:14 PM IST 
//


package io.smart.swings.x2jparser.builder.components;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Label complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Label">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="labelToolTip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="labelName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelAction" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelImage" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelXPos" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelYPos" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelHeight" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelWidth" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="labelListeners" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Label", propOrder = {
    "labelToolTip"
})
public class Label {

    protected String labelToolTip;
    @XmlAttribute(name = "labelName", required = true)
    protected String labelName;
    @XmlAttribute(name = "labelAction", required = true)
    protected String labelAction;
    @XmlAttribute(name = "labelImage")
    protected String labelImage;
    @XmlAttribute(name = "labelXPos")
    protected String labelXPos;
    @XmlAttribute(name = "labelYPos")
    protected String labelYPos;
    @XmlAttribute(name = "labelHeight")
    protected String labelHeight;
    @XmlAttribute(name = "labelWidth")
    protected String labelWidth;
    @XmlAttribute(name = "labelListeners")
    protected String labelListeners;

    /**
     * Gets the value of the labelToolTip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelToolTip() {
        return labelToolTip;
    }

    /**
     * Sets the value of the labelToolTip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelToolTip(String value) {
        this.labelToolTip = value;
    }

    /**
     * Gets the value of the labelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelName() {
        return labelName;
    }

    /**
     * Sets the value of the labelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelName(String value) {
        this.labelName = value;
    }

    /**
     * Gets the value of the labelAction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelAction() {
        return labelAction;
    }

    /**
     * Sets the value of the labelAction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelAction(String value) {
        this.labelAction = value;
    }

    /**
     * Gets the value of the labelImage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelImage() {
        return labelImage;
    }

    /**
     * Sets the value of the labelImage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelImage(String value) {
        this.labelImage = value;
    }

    /**
     * Gets the value of the labelXPos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelXPos() {
        return labelXPos;
    }

    /**
     * Sets the value of the labelXPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelXPos(String value) {
        this.labelXPos = value;
    }

    /**
     * Gets the value of the labelYPos property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelYPos() {
        return labelYPos;
    }

    /**
     * Sets the value of the labelYPos property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelYPos(String value) {
        this.labelYPos = value;
    }

    /**
     * Gets the value of the labelHeight property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelHeight() {
        return labelHeight;
    }

    /**
     * Sets the value of the labelHeight property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelHeight(String value) {
        this.labelHeight = value;
    }

    /**
     * Gets the value of the labelWidth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelWidth() {
        return labelWidth;
    }

    /**
     * Sets the value of the labelWidth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelWidth(String value) {
        this.labelWidth = value;
    }

    /**
     * Gets the value of the labelListeners property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabelListeners() {
        return labelListeners;
    }

    /**
     * Sets the value of the labelListeners property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabelListeners(String value) {
        this.labelListeners = value;
    }

}
