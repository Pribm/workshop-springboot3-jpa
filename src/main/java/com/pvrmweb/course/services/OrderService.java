package com.pvrmweb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pvrmweb.course.entities.Order;
import com.pvrmweb.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public Order save(Order order) {
		return repository.save(order);
	}

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		return repository.findById(id).get();
	}

	public Order deleteById(Long id) {
		Order order = this.findById(id);
		
		if(order != null) {
			repository.deleteById(id);
			return order;
		}
		
		throw new RuntimeException("Order Not Found");
	}
}
