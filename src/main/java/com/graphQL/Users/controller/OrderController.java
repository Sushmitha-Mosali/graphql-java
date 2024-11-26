package com.graphQL.Users.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphQL.Users.entities.Order;
import com.graphQL.Users.entities.User;
import com.graphQL.Users.service.OrderService;
import com.graphQL.Users.service.UserService;

@Controller
public class OrderController {

	private UserService userService;
	
	private OrderService orderService;

	public OrderController(UserService userService, OrderService orderService) {
		
		this.userService = userService;
		this.orderService = orderService;
	}
	@MutationMapping
	public Order createOrder(@Argument	String orderDetail,
		@Argument	String address,		@Argument	int price,		@Argument	int UserId
			) 
	 {
		
		User user=userService.getUser(UserId);
		Order order=new Order();
		order.setAddress(address);
		order.setOrderDetails(orderDetail);
		order.setPrice(price);
		order.setUser(user);
		
		Order newOrder=orderService.createOrder(order);
		return newOrder;
		
		
	}
	
	@QueryMapping
	public List<Order> getOrders(){
		return orderService.getAllOrders();
	}
	
	@QueryMapping
	public Order getOrder(@Argument int orderId) {
		return orderService.getOrder(orderId);
	}
	
	@MutationMapping
	public boolean deleteOrder(int orderId) {
		return orderService.deleteOrder(orderId);
		
	}
	
}
