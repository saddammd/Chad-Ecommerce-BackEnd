package com.ecommerce.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.Category_response;
import com.ecommerce.ecommerce.services.ProductsCategory_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ecommerce/api/v1")
public class Category_Controller {

	@Autowired
	ProductsCategory_Service productsCategory_Service;
	
	@GetMapping("/category")
	public ResponseEntity<List<Category_response>> showCategory(){
		
		List<Category_response> showCategory = productsCategory_Service.showCategory();
		return ResponseEntity.status(HttpStatus.OK).body(showCategory);
	}
}
