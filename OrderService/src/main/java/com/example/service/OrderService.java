package com.example.service;

import com.example.model.OrderRequest;

public interface OrderService {

	Long placeOrder(OrderRequest orderRequest);

}
