package com.zbodya.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zbodya.Model.Customer;
import com.zbodya.Repositories.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Customer customer = customerRepo.findByUsername(username);		
		UserDetails userDet = User.withUsername(customer.getUsername()).password(new BCryptPasswordEncoder().encode(customer.getPassword())).authorities(customer.getRole()).authorities(customer.getAuthority()).build();
		return userDet;
	}

}
