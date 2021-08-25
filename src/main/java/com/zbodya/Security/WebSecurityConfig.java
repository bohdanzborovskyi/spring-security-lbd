package com.zbodya.Security;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.zbodya.Service.CustomUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Resource
	private CustomUserDetailsService userDetailServ;
	
	@Bean
	public DaoAuthenticationProvider authProvider() 
	{
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailServ);
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() 
	{
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.httpBasic().and().authorizeRequests()
			.antMatchers(HttpMethod.GET,"/api/user/get")
//			.permitAll()
			.hasAnyAuthority("ADMIN","USER_READ")
			.antMatchers(HttpMethod.PUT, "/api/user/update")
//			.hasAnyRole("USER","ADMIN")
			.hasAnyAuthority("USER_EDIT","ADMIN")
			.antMatchers(HttpMethod.GET, "/api/admin/get")
//			.hasAnyRole("USER","ADMIN")
			.hasAuthority("ADMIN")
			.antMatchers(HttpMethod.POST, "/api/admin/createUser")
//			.hasRole("ADMIN")
			.hasAuthority("ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/admin/deleteUser")
//			.hasRole("ADMIN")
			.hasAuthority("ADMIN")
			.and().formLogin();			
	}
	
}
