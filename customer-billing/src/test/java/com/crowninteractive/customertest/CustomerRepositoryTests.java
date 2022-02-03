package com.crowninteractive.customertest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.crowninteractive.customer.Customer;
import com.crowninteractive.customer.CustomerRepository;






@DataJpaTest(showSql = false)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)

public class CustomerRepositoryTests {

	@Autowired
	private CustomerRepository repo;
	
	@Test
	public void testCreateRootCustomer() {
		Customer customer = new Customer("abbeys","damis","bioduns.banjoko@yahoo.com");
		Customer savedCustomer = repo.save(customer);
		
		assertThat(savedCustomer.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<Customer> listCustomers = repo.findAll();
		listCustomers.forEach(customer -> System.out.println(customer));
	}
	
	@Test
	public void testGetUserById() {
		Customer userHabay = repo.findById(1).get();
		System.out.println(userHabay);
		assertThat(userHabay).isNotNull();
	}
	
}
