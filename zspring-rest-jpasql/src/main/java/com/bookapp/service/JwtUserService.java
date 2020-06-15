package com.bookapp.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class JwtUserService implements UserDetailsService{
	// if u want autowire USer repo and use @Query
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String pass = passwordEncoder.encode("password");
		if(username.equals("Raju")) {
			// encrypt password
			return new User("Raju",pass, new ArrayList<>());
		}else 
			throw new UsernameNotFoundException("username not found");
	}	
}
