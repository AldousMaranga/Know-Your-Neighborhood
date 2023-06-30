package com.api.KnowYourNeighborhood.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.api.KnowYourNeighborhood.entity.User;
import com.api.KnowYourNeighborhood.service.UserService;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	

	
	@PostMapping(value="/registration")
	public String userRegistration(@RequestBody User user) {
		userService.registerUser(user);
		return "User Registered";
	}
	
	@GetMapping(value="/viewAllUser")
	public List<User> viewAllUser() {
		return userService.getAllUsers();
	}
	
	@PostMapping(value="/loginUser")
	public String login(@RequestParam String username, @RequestParam String password) {
		if (userService.userRegistered(username, password)) {
			return "Login Successful";
		} else {
			return "Login Failure";
		}	
	}
	
	
	@DeleteMapping(value="/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) { 
		userService.deleteUser(id);
		return "User deleted successfully";
	}
}
