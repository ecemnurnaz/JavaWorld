package edu.sabanciuniv.it526.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CreditCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cardName;
	private int cardNumber;
	
	@ManyToOne
	private User user;
	@OneToMany(mappedBy = "card")
	private List<Payment> payments;
	
	public CreditCard() {
		super();
	}

	public CreditCard(String cardName, int cardNumber, User user) {
		super();
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	@Override
	public String toString() {
		return "CreditCard [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", user=" + user
				+ "]";
	}
	
	
}
