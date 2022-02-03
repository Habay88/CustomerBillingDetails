package com.crowninteractive.billingdetails;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crowninteractive.customer.Customer;
import com.crowninteractive.customer.CustomerService;

@RestController
@RequestMapping(path="/billing")
@CrossOrigin("*")
public class BillingController {


	@Autowired
	private CustomerService customerservice;
	
	@Autowired
	private BillingService billingservice;
	
	// get billing  by id
			@GetMapping("/getbilling-by-id/{id}")
			public ResponseEntity<Object> getCustomer(@PathVariable int id){
				
				Optional<Billing> billing = billingservice.findById(id);
				
				if(billing.isEmpty()) {
					return new ResponseEntity<>("No record found", HttpStatus.OK);
				}
				return new ResponseEntity<>(billing, HttpStatus.OK);
			}
	
	@PostMapping("/add/{id}")
	public ResponseEntity<Object> save(@RequestBody Billing billing, @PathVariable int id) {
		
		String end = "-01";
		
		String accountnumber = billing.getAccountnumber();
	
		
	    Pattern pattern = Pattern.compile("^\\d{10}$");
	    
		Matcher matcher = pattern.matcher(accountnumber);
		
		String acctNumber = accountnumber+end;
		
		billing.setAccountnumber(acctNumber);
		
		Optional<Billing> newBilling = billing.findByAccountnumber(acctNumber);
		
		// check if  the account number is less or greater than 10
		if(accountnumber.length() != 10) {
			return new ResponseEntity<>("account number must be 10 characters long", HttpStatus.OK);
		}
		
		// check if account number already exist
		if(newBilling.isPresent()) {
			return new ResponseEntity<>("duplicate account number", HttpStatus.OK);
		}
		
		// check if account number does not contain any letter
		if(!matcher.matches()) {
			return new ResponseEntity<>("Account number can not contain alphabet", HttpStatus.OK);
		}
		
		Optional<Customer> customer = customerservice.findById(id);
		
		if(customer.isEmpty()) {
			return new ResponseEntity<>("no user found", HttpStatus.OK);
		}
		
		// upon passing through all conditions 
		
		 billing.setCustomer(customer.get());
		
		Billing billdetails = billingservice.save( billing);
		
		return new ResponseEntity<>(billdetails, HttpStatus.OK);
		
	}
	
	
		
		
		// get billing details by account number
		@GetMapping("/get-billing-by-account/{account}")
		public ResponseEntity<Object> getCustomer(@PathVariable String account){
			
			Optional<Billing> billing = billingservice.findByAccountnumber(account);
			
			if(billing.isEmpty()) {
				return new ResponseEntity<>("No record found", HttpStatus.OK);
			}
			return new ResponseEntity<>(billing, HttpStatus.OK);
		}
		
		
}
