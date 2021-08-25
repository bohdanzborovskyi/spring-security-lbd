package com.zbodya.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/admin")
public class AdminController 
{
	
	@GetMapping("/get")
	public String getAdmin() 
	{
		return "This is admin";
	}
	
	@PostMapping("/createUser")
	public String createUser() 
	{
		return "User created!";
	}
	
	@DeleteMapping("/deleteUser")
	public String deleteUser() 
	{
		return "User deleted!";
	}
	
}
