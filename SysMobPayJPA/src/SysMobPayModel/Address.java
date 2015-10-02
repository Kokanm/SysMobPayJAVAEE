package SysMobPayModel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the address database table.
 * 
 */
@Entity
@NamedQuery(name="Address.findAll", query="SELECT a FROM Address a")
@XmlRootElement
public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int address_ID;

	private String city;

	private String country;

	private int number;

	private String postalCode;

	private String street;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_ID")
	private User user;

	//bi-directional many-to-one association to Company
	@OneToMany(mappedBy="address")
	private List<Company> companies;

	//bi-directional many-to-one association to Order
	@OneToMany(mappedBy="address")
	private List<Order> orders;

	public Address() {
	}

	@XmlID
	@XmlElement
	public int getAddress_ID() {
		return this.address_ID;
	}

	public void setAddress_ID(int address_ID) {
		this.address_ID = address_ID;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getNumber() {
		return this.number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@XmlIDREF
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@XmlTransient
	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public Company addCompany(Company company) {
		getCompanies().add(company);
		company.setAddress(this);

		return company;
	}

	public Company removeCompany(Company company) {
		getCompanies().remove(company);
		company.setAddress(null);

		return company;
	}

	public List<Order> getOrders() {
		return this.orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public Order addOrder(Order order) {
		getOrders().add(order);
		order.setAddress(this);

		return order;
	}

	public Order removeOrder(Order order) {
		getOrders().remove(order);
		order.setAddress(null);

		return order;
	}

}