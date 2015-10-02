
package si.uni_lj.fri.prpo.SysMobPay.sporocila;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SysMobPayOdgovorSporocilo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SysMobPayOdgovorSporocilo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderReceived" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SysMobPayOdgovorSporocilo", propOrder = {
    "orderReceived"
})
public class SysMobPayOdgovorSporocilo {

    protected boolean orderReceived;

    /**
     * Gets the value of the orderReceived property.
     * 
     */
    public boolean isOrderReceived() {
        return orderReceived;
    }

    /**
     * Sets the value of the orderReceived property.
     * 
     */
    public void setOrderReceived(boolean value) {
        this.orderReceived = value;
    }

}
