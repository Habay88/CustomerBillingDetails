package com.crowninteractive.billingdetails;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;



public interface BillingRepository extends PagingAndSortingRepository<Billing, Integer> {

	Optional<Billing> findByAccountnumber(String acctnum);
}
