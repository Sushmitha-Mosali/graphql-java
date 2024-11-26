package com.graphQL.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQL.Users.entities.User;
import com.graphQL.Users.service.UserService;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	User save(UserService user);

	//custom query 
	
	
}
