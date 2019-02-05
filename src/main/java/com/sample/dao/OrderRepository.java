package com.sample.dao;

import org.springframework.stereotype.Component;

import com.sample.domain.Order;
@Component
public class OrderRepository extends InMemoryRepository<Order>{

	@Override
	protected void updateIfExists(Order original, Order desired) {
		// TODO Auto-generated method stub
		
		original.setDiscription(desired.getDiscription());
		original.setCost(desired.getCost());
		original.setComplete(desired.isComplete());
		
	}

}
