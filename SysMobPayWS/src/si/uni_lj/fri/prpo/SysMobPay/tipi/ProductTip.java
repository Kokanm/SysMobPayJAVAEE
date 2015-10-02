
package si.uni_lj.fri.prpo.SysMobPay.tipi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ProductTip complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProductTip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="product_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="company_ID" type="{http://fri.uni-lj.si/prpo/SysMobPay/tipi}CompanyTip"/>
 *         &lt;element name="productName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
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
@XmlType(name = "ProductTip", propOrder = {
    "productID",
    "companyID",
    "productName",
    "description",
    "price",
    "bonusPoints"
})
public class ProductTip {

    @XmlElement(name = "product_ID")
    protected int productID;
    @XmlElement(name = "company_ID", required = true)
    protected CompanyTip companyID;
    @XmlElement(required = true)
    protected String productName;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected BigDecimal price;
    protected int bonusPoints;

    /**
     * Gets the value of the productID property.
     * 
     */
    public int getProductID() {
        return productID;
    }

    /**
     * Sets the value of the productID property.
     * 
     */
    public void setProductID(int value) {
        this.productID = value;
    }

    /**
     * Gets the value of the companyID property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyTip }
     *     
     */
    public CompanyTip getCompanyID() {
        return companyID;
    }

    /**
     * Sets the value of the companyID property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyTip }
     *     
     */
    public void setCompanyID(CompanyTip value) {
        this.companyID = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
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
