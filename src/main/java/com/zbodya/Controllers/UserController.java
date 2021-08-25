package com.zbodya.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController 
{

	@GetMapping("/get")
	public String getUser() 
	{
		return "This is user!";
	}
	
	@PutMapping("/update")
	public String updateUser()
	{
		return "User updated!";
	}
	
	
}
