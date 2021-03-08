package com.ga.thespender.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ga.thespender.config.JwtUtil;
import com.ga.thespender.dao.UserDao;
import com.ga.thespender.model.JwtResponse;
import com.ga.thespender.model.User;

//@CrossOrigin(origins = "https://pages.git.generalassemb.ly/adel-kalu/The-Spender/")
@RestController
public class UserController {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	HttpServletRequest request;
	
	// Routes 
	
	// To post the registration form
	 @PostMapping("/user/registration")
	 public HashMap<String, String> registration(@RequestBody User user) {
		 HashMap<String, String> response = new HashMap<String, String>();
	 
		 // Check to user is already registered or not
		 var it = dao.findAll();
		 for(User dbUser : it) {
			 if(dbUser.getEmailAddress().equals(user.getEmailAddress())) {		 
				 response.put("message", "User already exists");
				 return response;		 
			 }
		 }
	 
		 // Password Encryption
		 BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
		 String newPassword = bCrypt.encode(user.getPassword());
		 user.setPassword(newPassword);
		 dao.save(user); 
		 response.put("message", "User registered successfully");
		 return response;	 
	 }
	 
	 @Autowired
	 AuthenticationManager authenticationManager;
	 
	 @Autowired
	 JwtUtil jwtUtil;
	 
	 @Autowired
	 UserDetailsService userDetailsService;
	 
	 @PostMapping("/user/authenticate")
	 public ResponseEntity<?> authenticate(@RequestBody User user) {	 
		 try {
			 authenticationManager.authenticate(
					 new UsernamePasswordAuthenticationToken(user.getEmailAddress(), user.getPassword())
					 );
		 }
		 catch(BadCredentialsException e) {
			 String res = "Incorrect username or password";
			 return ResponseEntity.ok(res);
		 }
		 
		// Continue 
		UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmailAddress());
		String jwtToken = jwtUtil.generateToken(userDetails);
		System.out.println(jwtToken);
		return ResponseEntity.ok(new JwtResponse(jwtToken));	 
	 }
	 

		// HTTP GET REQUEST - user Detail
		@GetMapping("/user/detail")
		public User userDetails(@RequestParam int id) {
			System.out.println(id);
			User user = dao.findById(id);
			return user;
		}
		
		// HTTP GET REQUEST - user Index
		@GetMapping("/user/index")
		public Iterable<User> getSpend() {
			var it = dao.findAll();
			return it;
		}
		
		// HTTP GET REQUEST - User Edit
		@PutMapping("/user/edit")
		 public HashMap<String, String> edit(@RequestBody User user) {
			 HashMap<String, String> response = new HashMap<String, String>();
			 
			 // Password Encryption
			 BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
			 String newPassword = bCrypt.encode(user.getPassword());
			 user.setPassword(newPassword);
			 dao.save(user); 
			 response.put("message", "User editing successfully");
			 return response;	 
		 }
		
		// HTTP GET REQUEST - User Delete
		@DeleteMapping("/user/delete")
		public boolean deleteUser(@RequestParam int id) {
			User user = dao.findById(id);
			dao.deleteById(id);
			return true;
		}
}
