package com.sample.utils;

// to build the json
import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.sample.domain.Order;

public class OrderResource extends ResourceSupport{

//	private final long id;
//	private final String desciption;
//	private final long cost;
//	private final boolean isComplete;
	
	@JsonUnwrapped
	private Order order;
	
	public OrderResource(Order order) {
		this.order=order;
	}
//	public OrderResource(long id, String desciption, long cost, boolean isComplete) {
//		super();
//		this.id = id;
//		this.desciption = desciption;
//		this.cost = cost;
//		this.isComplete = isComplete;
//	}
//
//	@JsonProperty("id")
//	public long getResourceId() {
//		return id;
//	}
//
//	public String getDesciption() {
//		return desciption;
//	}
//
//	public long getCost() {
//		return cost;
//	}
//
//	public boolean isComplete() {
//		return isComplete;
//	}
	
	
	
}
