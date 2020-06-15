package com.bookapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.config.JwtTokenUtil;
import com.bookapp.models.JwtResponse;
import com.bookapp.models.JwtUser;
import com.bookapp.service.JwtUserService;

@RestController
public class JwtAuthenticationController {

	@Autowired
	AuthenticationManager authManager;
	@Autowired
	JwtUserService userService;
	@Autowired
	JwtTokenUtil jwtTokenUtil;

	@PostMapping("/authenticate")
	public ResponseEntity<?> generateToken(@RequestBody JwtUser user){
		//get username and pass from request body
		String username = user.getUsername();
		String password = user.getPassword();
		// specify the auth provider type to authManager
		authManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		// check whether username is in the database, file, repo
		//call method of service
		UserDetails userDetails = userService.loadUserByUsername(username);
		// create token by passing user details to the util class
		String jwtToken = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(jwtToken));
	}


}
