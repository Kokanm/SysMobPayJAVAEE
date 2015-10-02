package SysMobPayModel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the order database table.
 * 
 */
@Entity
@NamedQuery(name="Order.findAll", query="SELECT o FROM Order o")
@XmlRootElement
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int order_ID;

	private int bonusReward;

	private int bonusUsed;

	@Temporal(TemporalType.DATE)
	private Date dateOfOrder;

	private String deliveryName;

	private BigDecimal price;

	private BigDecimal taxPrice;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="deliveryAddressID")
	private Address address;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_ID")
	private User user;

	//bi-directional many-to-one association to Orderdetail
	@OneToMany(mappedBy="order")
	private List<Orderdetail> orderdetails;

	public Order() {
	}

	@XmlID
	@XmlElement
	public int getOrder_ID() {
		return this.order_ID;
	}

	public void setOrder_ID(int order_ID) {
		this.order_ID = order_ID;
	}

	public int getBonusReward() {
		return this.bonusReward;
	}

	public void setBonusReward(int bonusReward) {
		this.bonusReward = bonusReward;
	}

	public int getBonusUsed() {
		return this.bonusUsed;
	}

	public void setBonusUsed(int bonusUsed) {
		this.bonusUsed = bonusUsed;
	}

	public Date getDateOfOrder() {
		return this.dateOfOrder;
	}

	public void setDateOfOrder(Date dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public String getDeliveryName() {
		return this.deliveryName;
	}

	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTaxPrice() {
		return this.taxPrice;
	}

	public void setTaxPrice(BigDecimal taxPrice) {
		this.taxPrice = taxPrice;
	}

	@XmlIDREF
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@XmlIDREF
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@XmlTransient
	public List<Orderdetail> getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(List<Orderdetail> orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Orderdetail addOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().add(orderdetail);
		orderdetail.setOrder(this);

		return orderdetail;
	}

	public Orderdetail removeOrderdetail(Orderdetail orderdetail) {
		getOrderdetails().remove(orderdetail);
		orderdetail.setOrder(null);

		return orderdetail;
	}

}