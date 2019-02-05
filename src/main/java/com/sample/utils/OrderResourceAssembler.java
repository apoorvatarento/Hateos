package com.sample.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.concurrent.LinkedTransferQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.sample.customerorder.OrderControll;
import com.sample.domain.Order;

@Component
public class OrderResourceAssembler extends ResourceAssembler<Order, OrderResource> {

	@Autowired
	protected EntityLinks entityLinks;
	
	public static final String UPDATE_REL="update";
	public static final String DELETE_REL="delete";
	public static final String FETCH_REL="fetch";
	
	
	
	@Override
	public OrderResource toResource(Order domainObj) {
		// TODO Auto-generated method stub
		
OrderResource resource = new OrderResource(domainObj)	;	
		final Link selfLinks=entityLinks.linkToSingleResource(domainObj);
		
		resource.add(selfLinks.withSelfRel());
		resource.add(selfLinks.withRel(UPDATE_REL));
		resource.add(selfLinks.withRel(DELETE_REL));

		Link link1=ControllerLinkBuilder.linkTo(OrderControll.class).slash(domainObj).slash(domainObj.getDiscription()).withRel("tester");
		resource.add(link1);
ResponseEntity<Collection<OrderResource>> methodBuilder=ControllerLinkBuilder.methodOn(OrderControll.class).findAllOrders();
		
Link link2=ControllerLinkBuilder.linkTo(methodBuilder).withRel("allorders");
resource.add(link2);
		return resource;
	}

}
