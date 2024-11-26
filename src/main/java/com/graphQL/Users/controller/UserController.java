package com.graphQL.Users.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.graphQL.Users.entities.User;
import com.graphQL.Users.service.UserService;

@Controller
public class UserController {

	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService=userService;
		
	}
	@MutationMapping
	public User createUser(@Argument String name,@Argument String password , @Argument String email ) {
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		return userService.createUser(user);
		
	}
	@QueryMapping(name="getUsers")
	public List<User> getAllUsers(){

		return userService.getAllUser();
	}
	
	@QueryMapping
	public User getUser(@Argument int userId) {
		
		return userService.getUser(userId);
	}
	@MutationMapping
	public boolean deleteUser(int userId) {
		return userService.deleteUser(userId);
	}
}
