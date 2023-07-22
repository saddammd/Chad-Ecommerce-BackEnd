package com.ecommerce.ecommerce.services;

import java.util.Optional;

import org.springframework.data.domain.Page;

import com.ecommerce.ecommerce.entities.Product;

public interface Products_Service {
	
	public Page<Product> findAll(int pageNumber, int pageSize);
	
	public Page<Product> findByCategoryId(int pageNumber, int pageSize, Integer categoryId);

	public Page<Product> findBySearch(int pageNumber, int pageSize, String search);

	public Product findByProductId(Long id);

}
