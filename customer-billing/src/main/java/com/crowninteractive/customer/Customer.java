package com.crowninteractive.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.crowninteractive.billingdetails.Billing;


@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(length = 64)
	@NotNull
	private String firstname;
	@Column(length = 64)
	@NotNull
	private String lastName;
	
	@Email
	@Column(length = 64, nullable = false, unique = true)
	private String email;
	 
	@OneToOne(mappedBy = "customer")
	private Billing billingdetails;
	
	
	public Customer() {
	
	}
	
	public Customer(String firstname, String lastName,  String email) {
		this.firstname = firstname;
		this.lastName = lastName;
		this.email = email;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastName=" + lastName + ", email=" + email + "]";
	}
	

	
	
}
