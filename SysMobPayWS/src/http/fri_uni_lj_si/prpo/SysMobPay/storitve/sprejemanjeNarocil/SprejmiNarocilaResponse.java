
package http.fri_uni_lj_si.prpo.SysMobPay.storitve.sprejemanjeNarocil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import si.uni_lj.fri.prpo.SysMobPay.sporocila.SysMobPayOdgovorSporocilo;


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
 *         &lt;element name="output" type="{http://fri.uni-lj.si/prpo/SysMobPay/sporocila}SysMobPayOdgovorSporocilo"/>
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
    "output"
})
@XmlRootElement(name = "SprejmiNarocilaResponse")
public class SprejmiNarocilaResponse {

    @XmlElement(required = true)
    protected SysMobPayOdgovorSporocilo output;

    /**
     * Gets the value of the output property.
     * 
     * @return
     *     possible object is
     *     {@link SysMobPayOdgovorSporocilo }
     *     
     */
    public SysMobPayOdgovorSporocilo getOutput() {
        return output;
    }

    /**
     * Sets the value of the output property.
     * 
     * @param value
     *     allowed object is
     *     {@link SysMobPayOdgovorSporocilo }
     *     
     */
    public void setOutput(SysMobPayOdgovorSporocilo value) {
        this.output = value;
    }

}
