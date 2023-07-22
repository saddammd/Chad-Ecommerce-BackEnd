package com.ecommerce.ecommerce.services;

import java.util.List;

import com.ecommerce.ecommerce.dto.Category_response;
import com.ecommerce.ecommerce.entities.ProductCategory;

public interface ProductsCategory_Service {
	
	public List<Category_response> showCategory();

}
