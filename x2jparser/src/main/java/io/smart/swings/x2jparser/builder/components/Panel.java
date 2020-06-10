//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.06.03 at 07:15:14 PM IST 
//


package io.smart.swings.x2jparser.builder.components;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Panel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Panel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="label" type="{}Label" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="formComponent" type="{}FormComponent" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="button" type="{}Button" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="panelName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="subPanelName" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Panel", propOrder = {
    "label",
    "formComponent",
    "button"
})
public class Panel {

    protected List<Label> label;
    protected List<FormComponent> formComponent;
    protected List<Button> button;
    @XmlAttribute(name = "panelName", required = true)
    protected String panelName;
    @XmlAttribute(name = "subPanelName", required = true)
    protected String subPanelName;

    /**
     * Gets the value of the label property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the label property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLabel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Label }
     * 
     * 
     */
    public List<Label> getLabel() {
        if (label == null) {
            label = new ArrayList<Label>();
        }
        return this.label;
    }

    /**
     * Gets the value of the formComponent property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the formComponent property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFormComponent().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FormComponent }
     * 
     * 
     */
    public List<FormComponent> getFormComponent() {
        if (formComponent == null) {
            formComponent = new ArrayList<FormComponent>();
        }
        return this.formComponent;
    }

    /**
     * Gets the value of the button property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the button property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getButton().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Button }
     * 
     * 
     */
    public List<Button> getButton() {
        if (button == null) {
            button = new ArrayList<Button>();
        }
        return this.button;
    }

    /**
     * Gets the value of the panelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPanelName() {
        return panelName;
    }

    /**
     * Sets the value of the panelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPanelName(String value) {
        this.panelName = value;
    }

    /**
     * Gets the value of the subPanelName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubPanelName() {
        return subPanelName;
    }

    /**
     * Sets the value of the subPanelName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubPanelName(String value) {
        this.subPanelName = value;
    }

}
