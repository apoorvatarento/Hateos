package com.sample.domain;

import java.io.Serializable;
import java.util.Optional;

import org.springframework.hateoas.Identifiable;

@SuppressWarnings("rawtypes")
public class Order implements Identifiable<Long>{
	//public class Order {
	
	private long id;
	private String discription;
	private long cost;
	private boolean  isComplete;
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public long getCost() {
		return cost;
	}
	public void setCost(long cost) {
		this.cost = cost;
	}
	
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public void markComplete() {
		setComplete(true);
	}
	
	public void markInComplete() {
		setComplete(true);
	}
	
	public boolean isComplete() {
		return isComplete;
	}
	

}
