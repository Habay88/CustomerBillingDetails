package com.crowninteractive.customer;


import java.util.List;
import java.util.Optional;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/customer")
@CrossOrigin("*")
public class CustomerController {

	@Autowired
	CustomerService service;

	
	// API TO Save customer 
	@PostMapping(path = "/add")
	 @ResponseStatus(HttpStatus.CREATED)
	public void addCustomer( @Valid @RequestBody  Customer customer) {
	
		service.addCustomer(customer);
	}

//  api to retreive customers by their id
	@GetMapping("/getone/{id}")
	public ResponseEntity<Object> getCustomer(@PathVariable int id){
		
		Optional<Customer> customer = service.getById(id);
		
		if(customer.isEmpty()) {
			return new ResponseEntity<>("No user with the id"+ id + " found", HttpStatus.OK);
		}
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	
	//.. api to get the list of all customers
	@GetMapping(path = "/list")
	public List<Customer> getCustomers(){
		return service.getCustomers();
	}
	//.. api to get the list of all customers for better optimization in production
	 @GetMapping(value = "/page/{offset}/{limit}")
	    public List<Customer> getMainOffset(@PathVariable("offset") int offset, @PathVariable("limit") int limit) {
	        return service.getListBaseOnOffset(offset, limit);
	    }
}
