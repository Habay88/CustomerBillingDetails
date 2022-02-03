package com.crowninteractive.billingdetails;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crowninteractive.customer.Customer;
import com.crowninteractive.customer.CustomerRepository;

@Service
public class BillingService {
	
	@Autowired
	private BillingRepository repository;
	
 public List<Billing> getBillingss() {
	 return (List<Billing>) repository.findAll();
 }
 
 public void addCustomer(Billing billing) {
	 repository.save(billing);
 }
 public Optional<Billing> findByAccountnumber(String acctNumber) {
		
		return null;
	}

public Billing save(Billing billing) {
	
	return repository.save(billing);
}

public Optional<Billing> findById(int id) {

	return repository.findById(id);
}

}