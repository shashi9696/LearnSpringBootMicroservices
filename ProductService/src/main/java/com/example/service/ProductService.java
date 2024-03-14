package com.example.service;

import com.example.exception.ProductServiceException;
import com.example.model.ProductRequest;
import com.example.model.ProductResponse;

public interface ProductService {

	Long addProduct(ProductRequest productRequest);

	ProductResponse getProductById(Long productId) throws ProductServiceException;

	void reduceQuantity(Long productId, int quantity) throws ProductServiceException;

}
