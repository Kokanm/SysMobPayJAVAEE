package SysMobPayModel;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import java.util.List;


/**
 * The persistent class for the company database table.
 * 
 */
@Entity
@NamedQuery(name="Company.findAll", query="SELECT c FROM Company c")
@XmlRootElement
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int comapny_ID;

	private String email;

	private String name;

	private int phone;

	//bi-directional many-to-one association to Address
	@ManyToOne
	@JoinColumn(name="address_ID")
	private Address address;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="company")
	private List<Product> products;

	public Company() {
	}

	@XmlID
	@XmlElement
	public int getComapny_ID() {
		return this.comapny_ID;
	}

	public void setComapny_ID(int comapny_ID) {
		this.comapny_ID = comapny_ID;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@XmlTransient
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@XmlTransient
	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setCompany(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setCompany(null);

		return product;
	}

}