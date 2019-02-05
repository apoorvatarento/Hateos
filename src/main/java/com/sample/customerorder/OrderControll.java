package com.sample.customerorder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.dao.OrderRepository;
import com.sample.domain.Order;
import com.sample.utils.OrderResource;
import com.sample.utils.OrderResourceAssembler;

@CrossOrigin(origins="*")
@ExposesResourceFor(Order.class)
@ComponentScan({"com.sample.dao","com.sample.utils"})
@RestController
@RequestMapping(value="/order",produces="application/json")
public class OrderControll {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private OrderResourceAssembler assembler;
	
	@RequestMapping(value="/fetch",method=RequestMethod.GET)
	public ResponseEntity<Collection<OrderResource>> findAllOrders() {
		
	System.out.println("hi get");
		List<Order> orders=orderRepo.returnAll();
		return new ResponseEntity<>(assembler.toResourceCollection(orders), HttpStatus.OK);
	}
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<OrderResource> createOrder(@RequestBody Order order){
		System.out.println("add order");
	Order cretaeOrder=orderRepo.addOrder(order);
	return new ResponseEntity<>(assembler.toResource(cretaeOrder),HttpStatus.CREATED);
	
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces="application/json")
	public ResponseEntity<OrderResource> findOrderById(@PathVariable(value="id") long id){
		Optional<Order> fetchedOrder=orderRepo.findOrder(id);
		
		if(fetchedOrder.isPresent()) {
			return new ResponseEntity<OrderResource>(assembler.toResource(fetchedOrder.get()), HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
	}
	

	@RequestMapping(value="/{id]",method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteById(@PathVariable long id){
		boolean wasDeleted=orderRepo.delete(id);
		
		HttpStatus status=wasDeleted ? HttpStatus.NO_CONTENT:HttpStatus.NOT_FOUND;
		
		return new ResponseEntity<>(status);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<OrderResource> updateOrder(@PathVariable long id,@RequestBody Order order){
		boolean wasUpdated=orderRepo.updateOrder(id, order);
		
		ResponseEntity entity =wasUpdated ?  findOrderById(id): new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		return entity;
	}
	
}
