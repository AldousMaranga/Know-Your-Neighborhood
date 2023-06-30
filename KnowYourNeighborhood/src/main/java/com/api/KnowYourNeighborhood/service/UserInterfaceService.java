package com.api.KnowYourNeighborhood.service;

import java.util.List;

import com.api.KnowYourNeighborhood.entity.User;

public interface UserInterfaceService {
	
	void registerUser (User user);
	boolean userRegistered (String username, String password);
	List<User> getAllUsers();
	void deleteUser (int id);
}
