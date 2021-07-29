package com.springRest.springRest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springRest.springRest.dao.UserRepository;
import com.springRest.springRest.entities.regAndLogin.Contact;
import com.springRest.springRest.entities.regAndLogin.User;

@RestController
public class HomeController {
	
	@Autowired
	private UserRepository userepository;
	
	@GetMapping("/test")
	public String test() {
		
		User user = new User();
		
		user.setName("Mayank");
		user.setEmail("mayank.jha@gmail.com");
		
		Contact contact = new Contact();
		user.getContacts().add(contact);
		
		userepository.save(user);
	
		return  "Working";
		
	}
	
	@PostMapping("/validateForm")
	public List<String> validateRegistrationForm(@Valid @RequestBody User user, BindingResult result) {
		
		user.setRole("ROLE_USER");
		
		List<String> errors = new ArrayList<String>();
		if (result.hasErrors()) {
			for(ObjectError error: result.getAllErrors()) {
				errors.add(error.getDefaultMessage());
			}
		}
		
		return null;
	}
	
	
	@PostMapping("/register")
	public String registerUser(@Valid @RequestBody User user) {
		
		user.setRole("ROLE_USER");
		
		userepository.save(user);
		
		return user.toString();
	}
}
