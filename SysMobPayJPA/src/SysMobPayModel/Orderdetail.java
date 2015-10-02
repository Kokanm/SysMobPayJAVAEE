package SysMobPayModel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

import java.math.BigDecimal;


/**
 * The persistent class for the orderdetails database table.
 * 
 */
@Entity
@Table(name="orderdetails")
@NamedQuery(name="Orderdetail.findAll", query="SELECT o FROM Orderdetail o")
@XmlRootElement
public class Orderdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderdetails_ID;

	private int bonusPoints;

	private int quantity;

	private BigDecimal unitPrice;

	//bi-directional many-to-one association to Order
	@ManyToOne
	@JoinColumn(name="order_ID")
	private Order order;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product_ID")
	private Product product;

	public Orderdetail() {
	}

	@XmlID
	@XmlElement
	public int getOrderdetails_ID() {
		return this.orderdetails_ID;
	}

	public void setOrderdetails_ID(int orderdetails_ID) {
		this.orderdetails_ID = orderdetails_ID;
	}

	public int getBonusPoints() {
		return this.bonusPoints;
	}

	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@XmlIDREF
	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@XmlIDREF
	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}