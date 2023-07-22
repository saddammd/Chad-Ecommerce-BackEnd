package com.ecommerce.ecommerce.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.entities.ProductCategory;

@Repository
public interface Product_Dao extends JpaRepository<Product, Integer> {

	public Page<Product> findByproductCategory(ProductCategory category, PageRequest page);

	@Query("SELECT p FROM Product p WHERE p.name LIKE %?1%"
			+ " OR p.description LIKE %?1%"
			+ " OR CONCAT (p.unit_price, ' ') LIKE %?1%")
	public Page<Product> productSearch(String search, PageRequest page);
	
	public Product findById(Long id);

}
