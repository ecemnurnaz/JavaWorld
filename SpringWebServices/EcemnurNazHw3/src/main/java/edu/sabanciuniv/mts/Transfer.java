package edu.sabanciuniv.mts;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transfer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int senderIban;
	private int receiverIban;
	private double amount;
	private LocalDateTime date;
	
	public Transfer() {
		super();
	}

	public Transfer(int senderIban, int receiverIban, double amount, LocalDateTime date) {
		super();
		this.senderIban = senderIban;
		this.receiverIban = receiverIban;
		this.amount = amount;
		this.date = date;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSenderIban() {
		return senderIban;
	}

	public void setSenderIban(int senderIban) {
		this.senderIban = senderIban;
	}

	public int getReceiverIban() {
		return receiverIban;
	}

	public void setReceiverIban(int receiverIban) {
		this.receiverIban = receiverIban;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Transfer [senderIban=" + senderIban + ", receiverIban=" + receiverIban + ", amount=" + amount
				+ ", date=" + date + "]";
	}

	
	
	
	
}
