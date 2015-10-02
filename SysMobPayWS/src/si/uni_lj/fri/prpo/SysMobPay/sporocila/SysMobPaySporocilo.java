
package si.uni_lj.fri.prpo.SysMobPay.sporocila;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import si.uni_lj.fri.prpo.SysMobPay.tipi.SysMobPayTip;


/**
 * <p>Java class for SysMobPaySporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SysMobPaySporocilo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderRequest" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}SysMobPayTip"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SysMobPaySporocilo", propOrder = {
    "orderRequest"
})
public class SysMobPaySporocilo {

    @XmlElement(required = true)
    protected SysMobPayTip orderRequest;

    /**
     * Gets the value of the orderRequest property.
     * 
     * @return
     *     possible object is
     *     {@link SysMobPayTip }
     *     
     */
    public SysMobPayTip getOrderRequest() {
        return orderRequest;
    }

    /**
     * Sets the value of the orderRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysMobPayTip }
     *     
     */
    public void setOrderRequest(SysMobPayTip value) {
        this.orderRequest = value;
    }

}
