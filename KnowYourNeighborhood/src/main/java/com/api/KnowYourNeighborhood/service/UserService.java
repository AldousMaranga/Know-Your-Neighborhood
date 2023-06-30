package com.api.KnowYourNeighborhood.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.KnowYourNeighborhood.entity.User;
import com.api.KnowYourNeighborhood.repository.UserRepository;

@Service("UserInterfaceService")
public class UserService implements UserInterfaceService{
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void registerUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public boolean userRegistered(String username, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		if (user != null && user.getPassword().equals(password)) {
			return true;
		} else
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	
	
}
