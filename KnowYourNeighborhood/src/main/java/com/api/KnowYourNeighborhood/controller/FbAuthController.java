package com.api.KnowYourNeighborhood.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ="http://localhost:3000")
@RestController
	@RequestMapping("/user")
	public class FbAuthController {
	
	    @GetMapping
	    public Principal getUser(final Principal user) {
	        return user;
	    }
	}