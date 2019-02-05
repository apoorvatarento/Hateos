package com.CustomerOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;


@EnableEntityLinks
@EnableHypermediaSupport(type=HypermediaType.HAL)
@SpringBootApplication
@ComponentScan("com.sample.customerorder")
public class CustomerOrderWebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerOrderWebservicesApplication.class, args);
	}
}
