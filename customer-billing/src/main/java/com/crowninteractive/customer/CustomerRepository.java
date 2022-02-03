package com.crowninteractive.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
	  @Query(value = "SELECT * FROM policy p ORDER BY id DESC LIMIT :offset, :limit", nativeQuery = true)
		public List<Customer> getListBaseOnOffset(int offset, int limit);
}
