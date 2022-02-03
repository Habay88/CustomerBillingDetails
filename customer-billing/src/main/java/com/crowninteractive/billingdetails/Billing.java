package com.crowninteractive.billingdetails;

import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.crowninteractive.customer.Customer;

@Entity

@Table(name = "billing")
public class Billing {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 64, nullable = false, unique = true)
	private String accountnumber;
	
	@Column(length = 64)
	private Double tariff;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerid", referencedColumnName = "id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public Double getTariff() {
		return tariff;
	}

	public void setTariff(Double tariff) {
		this.tariff = tariff;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BillingDetails [id=" + id + ", accountnumber=" + accountnumber + ", tariff=" + tariff + ", customer="
				+ customer + "]";
	}

	public Optional<Billing> findByAccountnumber(String acctNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
