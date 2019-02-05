package com.test;

import static org.junit.Assert.assertEquals;

import java.awt.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.sample.dao.OrderRepository;
import com.sample.domain.Order;

@RunWith(SpringRunner.class)
public class TestOrderApi {

	Order testOrder=new Order();
	@Autowired OrderRepository oderRepo;
	
	@Test
	void testForAdd() {
		testOrder.setDiscription("test");
		testOrder.setCost(50);
		
		oderRepo.addOrder(testOrder);
		assertEquals(new List(), oderRepo.returnAll());
	}
	
}
