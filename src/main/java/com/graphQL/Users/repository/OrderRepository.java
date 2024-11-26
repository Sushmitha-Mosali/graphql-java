package com.graphQL.Users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphQL.Users.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	
}
