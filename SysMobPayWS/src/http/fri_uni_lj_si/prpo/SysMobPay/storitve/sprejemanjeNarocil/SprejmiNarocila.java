
package http.fri_uni_lj_si.prpo.SysMobPay.storitve.sprejemanjeNarocil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import si.uni_lj.fri.prpo.SysMobPay.sporocila.SysMobPaySporocilo;


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
 *         &lt;element name="input" type="{http://fri.uni-lj.si/prpo/SysMobPay/sporocila}SysMobPaySporocilo"/>
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
    "input"
})
@XmlRootElement(name = "SprejmiNarocila")
public class SprejmiNarocila {

    @XmlElement(required = true)
    protected SysMobPaySporocilo input;

    /**
     * Gets the value of the input property.
     * 
     * @return
     *     possible object is
     *     {@link SysMobPaySporocilo }
     *     
     */
    public SysMobPaySporocilo getInput() {
        return input;
    }

    /**
     * Sets the value of the input property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysMobPaySporocilo }
     *     
     */
    public void setInput(SysMobPaySporocilo value) {
        this.input = value;
    }

}
