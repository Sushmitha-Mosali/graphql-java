package com.graphQL.Users.service;

import java.util.List;

import org.springframework.boot.web.servlet.filter.OrderedRequestContextFilter;
import org.springframework.stereotype.Service;

import com.graphQL.Users.entities.Order;
import com.graphQL.Users.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;

	public OrderService(OrderRepository orderRepo) {
		
		this.orderRepo = orderRepo;
	}
	
	public Order createOrder(Order order) {
		return orderRepo.save(order);
	}
	
	public List<Order> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public Order getOrder(int orderId ) {
		Order order= orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("No Order Found !!"));
		return order;
	}
	
	public boolean deleteOrder(int orderId) {
		Order order=orderRepo.findById(orderId).orElseThrow(()->new RuntimeException("No Order  Found !!!"));
		
		orderRepo.delete(order);		
	    return true;
	}
	
}
