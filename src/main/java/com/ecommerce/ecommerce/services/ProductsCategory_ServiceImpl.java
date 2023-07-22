package com.ecommerce.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.dao.ProductCategory_Dao;
import com.ecommerce.ecommerce.dto.Category_response;
import com.ecommerce.ecommerce.entities.ProductCategory;

@Service
public class ProductsCategory_ServiceImpl implements ProductsCategory_Service {

	@Autowired
	ProductCategory_Dao productCategory_Dao;
	
	@Override
	public List<Category_response> showCategory() {
		
		List<ProductCategory> findAll = productCategory_Dao.findAll();
		
		ArrayList<Category_response> category_response = new ArrayList<Category_response>();
		for(ProductCategory p : findAll) {
			Category_response response = new Category_response();
		BeanUtils.copyProperties(p, response);
		category_response.add(response);
		}
		return category_response;
		
	}

	
	
}
