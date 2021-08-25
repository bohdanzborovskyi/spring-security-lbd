package com.zbodya.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zbodya.Model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> 
{
	Customer findByUsername(String username);
}
