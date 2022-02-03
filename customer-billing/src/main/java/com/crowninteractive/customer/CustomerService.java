package com.crowninteractive.customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository repository;
	
 public List<Customer> getCustomers() {
	 return (List<Customer>) repository.findAll();
 }
 

 
 public Optional<Customer> getById( int id) {
	 return repository.findById(id);
}

 public List<Customer> getListBaseOnOffset(int offset, int limit) {
		// TODO Auto-generated method stub
		return repository.findAll();
	}


 
 public void addCustomer(Customer customer) {
	 repository.save(customer);
 }

public Optional<Customer> findById(int id) {
	// TODO Auto-generated method stub
	 return repository.findById(id);
}


}
 







