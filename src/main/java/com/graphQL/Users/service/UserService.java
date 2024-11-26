package com.graphQL.Users.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.graphQL.Users.entities.User;
import com.graphQL.Users.repository.UserRepository;

@Service
public class UserService {
	
	private UserRepository userRepo;
	public UserService(UserRepository userRepo) {
		this.userRepo=userRepo;
	}
	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public List<User> getAllUser(){
		return userRepo.findAll();
	}
	
	public User getUser(int userId ) {
		User user= userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not Found !!"));
		return user;
	}
	
	public boolean deleteUser(int userId) {
		User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("User not Found !!!"));
		
		userRepo.delete(user);		
	    return true;
	}

}
