package com.example.service.impl;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.ProductService;
import com.example.entity.Order;
import com.example.model.OrderRequest;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;

import lombok.extern.log4j.Log4j2;
@Service
@Log4j2
public class OrderServiceImpl implements OrderService {
		
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ProductService productService;

	@Override
	public Long placeOrder(OrderRequest orderRequest) {
		log.info("before placing iorder");
		productService.reduceQuantity(orderRequest.getProductId(), orderRequest.getQuantity());
		log.info("after checking product availablity for product "+ orderRequest.getProductId());
		Order order = Order.builder()
				.productId(orderRequest.getProductId())
				.price(orderRequest.getAmount())
				.orderDate(Instant.now())
				.orderStatus("CREATED")
				.quantity(orderRequest.getQuantity())
				.build();
		log.info("Order placed");
		order = orderRepository.save(order);
		log.info("Product saved successfully after placing order");
		return order.getOrderId();
	}
	
	

}
