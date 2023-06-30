package com.api.LoginAPIs.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
	@RequestMapping("/user")
	public class FbAuthController {
	
	    @GetMapping
	    public Principal getUser(final Principal user) {
	        return user;
	    }
	}