package com.sample.utils;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class IdGenerator {

	private AtomicLong idGenerator=new AtomicLong();

	public AtomicLong getIdGenerator() {
		return idGenerator;
	}
	
	public long getNextId() {
		return idGenerator.getAndIncrement();
	}
}
