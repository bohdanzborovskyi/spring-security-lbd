package com.zbodya;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zbodya.Model.Customer;
import com.zbodya.Repositories.CustomerRepository;

@SpringBootApplication
public class SpringSecurityLbdApplication
{

	@Autowired
	CustomerRepository customerRepo;
	
	public static void main(String[] args) 
	{
		SpringApplication.run(SpringSecurityLbdApplication.class, args);
	}
	
	@PostConstruct
	public void postConstruct() 
	{
		Customer cust1 = new Customer("user","user","ROLE_USER","USER_EDIT");
		Customer cust3 = new Customer("spectator","spectator","ROLE_USER","USER_READ");
		Customer cust2 = new Customer("admin","admin","ROLE_ADMIN","ADMIN");
		customerRepo.save(cust3);
		customerRepo.save(cust1);
		customerRepo.save(cust2);
	}

}
