package edu.sabanciuniv.it526.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String date;
	
	@ManyToMany
	private List<Product> products;
	@ManyToOne
	private User user;
	@OneToOne
	private Payment payment;
	@OneToOne
	private Shipping shipping;
	
	public Order() {
		super();
	}
	public Order(String date, List<Product> products, User user, Payment payment, Shipping shipping) {
		super();
		this.date = date;
		this.products = products;
		this.user = user;
		this.payment = payment;
		this.shipping = shipping;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Shipping getShipping() {
		return shipping;
	}
	public void setShipping(Shipping shipping) {
		this.shipping = shipping;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", date=" + date + ", products=" + products + ", user=" + user + ", payment="
				+ payment + ", shipping=" + shipping + "]";
	}
	
	
}
