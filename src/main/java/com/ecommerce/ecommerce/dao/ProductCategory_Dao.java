package com.ecommerce.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entities.ProductCategory;

@Repository
public interface ProductCategory_Dao extends JpaRepository<ProductCategory, Integer>{

}
