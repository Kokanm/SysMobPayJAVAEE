
package si.uni_lj.fri.prpo.SysMobPay.tipi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DetailsTip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DetailsTip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="orderdetails_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="order_ID" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}WebOrderTip"/>
 *         &lt;element name="product_ID" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}ProductTip"/>
 *         &lt;element name="unitPrice" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bonusPoints" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DetailsTip", propOrder = {
    "orderdetailsID",
    "orderID",
    "productID",
    "unitPrice",
    "quantity",
    "bonusPoints"
})
public class DetailsTip {

    @XmlElement(name = "orderdetails_ID")
    protected int orderdetailsID;
    @XmlElement(name = "order_ID", required = true)
    protected WebOrderTip orderID;
    @XmlElement(name = "product_ID", required = true)
    protected ProductTip productID;
    @XmlElement(required = true)
    protected BigDecimal unitPrice;
    protected int quantity;
    protected int bonusPoints;

    /**
     * Gets the value of the orderdetailsID property.
     * 
     */
    public int getOrderdetailsID() {
        return orderdetailsID;
    }

    /**
     * Sets the value of the orderdetailsID property.
     * 
     */
    public void setOrderdetailsID(int value) {
        this.orderdetailsID = value;
    }

    /**
     * Gets the value of the orderID property.
     * 
     * @return
     *     possible object is
     *     {@link WebOrderTip }
     *     
     */
    public WebOrderTip getOrderID() {
        return orderID;
    }

    /**
     * Sets the value of the orderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebOrderTip }
     *     
     */
    public void setOrderID(WebOrderTip value) {
        this.orderID = value;
    }

    /**
     * Gets the value of the productID property.
     * 
     * @return
     *     possible object is
     *     {@link ProductTip }
     *     
     */
    public ProductTip getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductTip }
     *     
     */
    public void setProductID(ProductTip value) {
        this.productID = value;
    }

    /**
     * Gets the value of the unitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPrice(BigDecimal value) {
        this.unitPrice = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     */
    public void setQuantity(int value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the bonusPoints property.
     * 
     */
    public int getBonusPoints() {
        return bonusPoints;
    }

    /**
     * Sets the value of the bonusPoints property.
     * 
     */
    public void setBonusPoints(int value) {
        this.bonusPoints = value;
    }

}
