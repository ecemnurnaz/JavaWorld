package edu.sabanciuniv.it526.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String shipCompany;
	private String phone;
	
	@OneToOne(mappedBy = "shipping")
	private Order order;

	public Shipping() {
		super();
	}

	public Shipping(String shipCompany, String phone, Order order) {
		super();
		this.shipCompany = shipCompany;
		this.phone = phone;
		this.order = order;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShipCompany() {
		return shipCompany;
	}

	public void setShipCompany(String shipCompany) {
		this.shipCompany = shipCompany;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Shipping [id=" + id + ", shipCompany=" + shipCompany + ", phone=" + phone + ", order=" + order + "]";
	}
	
	
}
