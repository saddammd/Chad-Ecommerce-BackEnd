package com.ecommerce.ecommerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dao.Product_Dao;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ProductCategory;
import com.ecommerce.ecommerce.exceptions.productNotFoundException;

@Service
public class Products_ServiceImpl implements Products_Service {

	@Autowired
	private Product_Dao product_Dao;
	
	@Override
	public Page<Product> findAll(int pageNumber, int pageSize) {
		
		PageRequest page = PageRequest.of(pageSize, pageNumber);
		
		Page<Product> findAll = product_Dao.findAll(page);
		return findAll;
	}

	
	@Override
	public Page<Product> findByCategoryId(int pageNumber, int pageSize, Integer category_id) {
		
		PageRequest page = PageRequest.of(pageNumber, pageSize);
		
		ProductCategory category = new ProductCategory();
		category.setId(category_id);
		Page<Product> findAllByCategoryId = product_Dao.findByproductCategory(category, page);
		return findAllByCategoryId;
	}


	@Override
	public Page<Product> findBySearch(int pageNumber, int pageSize, String search) {
		PageRequest page = PageRequest.of(pageNumber, pageSize);
		Page<Product> findAllByCategoryId = product_Dao.productSearch(search, page);
		return findAllByCategoryId;

	}


	@Override
	public Product findByProductId(Long id) {
		Product findAllByCategoryId = product_Dao.findById(id);
		if(findAllByCategoryId.equals(null)) {
			throw new productNotFoundException("product not found with id" +id);
		}
		else {
		return findAllByCategoryId;
		}
	}

}
