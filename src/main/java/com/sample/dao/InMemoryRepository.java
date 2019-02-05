package com.sample.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import com.sample.domain.Order;
import com.sample.utils.IdGenerator;

public abstract class InMemoryRepository<T extends Order> {

	@Autowired 
	private IdGenerator id;
	
	List<T> orders= Collections.synchronizedList(new ArrayList<T>());
	
	public T addOrder(T order){
		System.out.println(order.getDiscription());
		orders.add(order);
		order.setId(id.getNextId());
		return order;
	}
	
	
	public boolean delete(long id) {
		
		return orders.removeIf(order -> order.getId().equals(id) );
		
	}


	public List<T> returnAll(){
		orders.sort((Order order,Order order1) -> {return (int) (order.getId() - order1.getId());});
		return orders;
	}
	
	
	public Optional<T> findOrder(long id) {
		
		return orders.stream().filter(order-> order.getId().equals(id)).findFirst();
		}
	
	public int getCount() {
		return orders.size();
	}
	
	public void clear() {
		 orders.clear();
	}


public boolean updateOrder(long id,T updateOrder) {
	
	if(updateOrder == null) {
		return false;
	}else {
		
		Optional<T> order=findOrder(id);
		order.ifPresent(original-> updateIfExists(original, updateOrder));
		System.out.println(order.isPresent());
		return order.isPresent();
		
	}
	
	
	
}


protected abstract void updateIfExists(T original, T desired);
}
