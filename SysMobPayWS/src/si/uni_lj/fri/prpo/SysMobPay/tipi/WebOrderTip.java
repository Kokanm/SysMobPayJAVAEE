
package si.uni_lj.fri.prpo.SysMobPay.tipi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for WebOrderTip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebOrderTip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="order_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="taxPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="bonusUsed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bonusReward" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="deliveryName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dateOfOrder" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="user_ID" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}UserTip"/>
 *         &lt;element name="deliveryAddressID" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}AddressTip"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebOrderTip", propOrder = {
    "orderID",
    "price",
    "taxPrice",
    "bonusUsed",
    "bonusReward",
    "deliveryName",
    "dateOfOrder",
    "userID",
    "deliveryAddressID"
})
public class WebOrderTip {

    @XmlElement(name = "order_ID")
    protected int orderID;
    @XmlElement(required = true)
    protected BigDecimal price;
    @XmlElement(required = true)
    protected BigDecimal taxPrice;
    protected int bonusUsed;
    protected int bonusReward;
    @XmlElement(required = true)
    protected String deliveryName;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar dateOfOrder;
    @XmlElement(name = "user_ID", required = true)
    protected UserTip userID;
    @XmlElement(required = true)
    protected AddressTip deliveryAddressID;

    /**
     * Gets the value of the orderID property.
     * 
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     */
    public void setOrderID(int value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the price property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrice(BigDecimal value) {
        this.price = value;
    }

    /**
     * Gets the value of the taxPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTaxPrice() {
        return taxPrice;
    }

    /**
     * Sets the value of the taxPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTaxPrice(BigDecimal value) {
        this.taxPrice = value;
    }

    /**
     * Gets the value of the bonusUsed property.
     * 
     */
    public int getBonusUsed() {
        return bonusUsed;
    }

    /**
     * Sets the value of the bonusUsed property.
     * 
     */
    public void setBonusUsed(int value) {
        this.bonusUsed = value;
    }

    /**
     * Gets the value of the bonusReward property.
     * 
     */
    public int getBonusReward() {
        return bonusReward;
    }

    /**
     * Sets the value of the bonusReward property.
     * 
     */
    public void setBonusReward(int value) {
        this.bonusReward = value;
    }

    /**
     * Gets the value of the deliveryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryName() {
        return deliveryName;
    }

    /**
     * Sets the value of the deliveryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryName(String value) {
        this.deliveryName = value;
    }

    /**
     * Gets the value of the dateOfOrder property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateOfOrder() {
        return dateOfOrder;
    }

    /**
     * Sets the value of the dateOfOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateOfOrder(XMLGregorianCalendar value) {
        this.dateOfOrder = value;
    }

    /**
     * Gets the value of the userID property.
     * 
     * @return
     *     possible object is
     *     {@link UserTip }
     *     
     */
    public UserTip getUserID() {
        return userID;
    }

    /**
     * Sets the value of the userID property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserTip }
     *     
     */
    public void setUserID(UserTip value) {
        this.userID = value;
    }

    /**
     * Gets the value of the deliveryAddressID property.
     * 
     * @return
     *     possible object is
     *     {@link AddressTip }
     *     
     */
    public AddressTip getDeliveryAddressID() {
        return deliveryAddressID;
    }

    /**
     * Sets the value of the deliveryAddressID property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressTip }
     *     
     */
    public void setDeliveryAddressID(AddressTip value) {
        this.deliveryAddressID = value;
    }

}
