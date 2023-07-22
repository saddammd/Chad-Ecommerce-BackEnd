package com.ecommerce.ecommerce.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.dto.ProductDto;
import com.ecommerce.ecommerce.dto.Product_Response;
import com.ecommerce.ecommerce.entities.Product;
import com.ecommerce.ecommerce.exceptions.InvalidPageException;
import com.ecommerce.ecommerce.exceptions.productNotFoundException;
import com.ecommerce.ecommerce.services.Products_Service;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/ecommerce/api/v1")
public class Products_Controller {

	@Autowired
	private Products_Service products_service;

	@GetMapping("/products")
	public ResponseEntity<Product_Response> find_Products(

			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,

			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber) throws Exception {

		if (pageSize >= 0) {
			Page<Product> findAll = products_service.findAll(pageSize, pageNumber);
			Product_Response response = new Product_Response();
			Map map = new HashMap();
			map.put("Page", findAll);
			response.setMessage("Retreived Products");
			response.setStatus(HttpStatus.ACCEPTED);
			response.setData(map);
			response.setTimestamp(System.currentTimeMillis());

			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		throw new InvalidPageException("Page Size Should Not Be Less Than 0");
	}

	@GetMapping("/products/{id}")
	public ResponseEntity<Product_Response> find_ProductsByCategory(HttpServletResponse response, @PathVariable Integer id,
			@RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber) throws Exception {

		if (pageSize >= 0) {

			if (id == null || id < 0 || id == 0) {
				response.sendRedirect("/ecommerce/api/v1/products");
			}

			else {
				Page<Product> findByCategoryId = products_service.findByCategoryId(pageNumber, pageSize, id);
				Product_Response response1 = new Product_Response();
				Map map = new HashMap();
				map.put("Page", findByCategoryId);
				response1.setMessage("Retreived Products");
				response1.setStatus(HttpStatus.ACCEPTED);
				response1.setData(map);
				response1.setTimestamp(System.currentTimeMillis());
				
				

				return ResponseEntity.status(HttpStatus.OK).body(response1);
			}
		}
		throw new InvalidPageException("Page Size Should Not Be Less Than 0");
	}

	@GetMapping("/products/search")
	public ResponseEntity<Product_Response> find_ProductsBySearch(HttpServletResponse response,
			@RequestParam(value = "search", required = false) String search,
			@RequestParam(value = "pageSize", defaultValue = "20", required = false) int pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber) throws Exception {

		if (pageSize >= 0) {

			if (search == null || search.isEmpty() || search.equals("")) {
				response.sendRedirect("/ecommerce/api/v1/products");
			}

			else {
				Page<Product> findBySearch = products_service.findBySearch(pageNumber, pageSize, search);

				if (!findBySearch.hasContent()) {
					throw new productNotFoundException("Product Not Found");
				}
				Product_Response Searchresponse = new Product_Response();
				Map map = new HashMap();
				map.put("Page", findBySearch);
				Searchresponse.setMessage("Retreived Products");
				Searchresponse.setStatus(HttpStatus.ACCEPTED);
				Searchresponse.setData(map);
				Searchresponse.setTimestamp(System.currentTimeMillis());

				return ResponseEntity.status(HttpStatus.OK).body(Searchresponse);
			}
		}
		throw new InvalidPageException("Page Size Should Not Be Less Than 0");
	}

	@GetMapping("/products/product/{id}")
	public ResponseEntity<ProductDto> find_ProductsById(@PathVariable Long id) throws Exception {

		Product findByProductId = products_service.findByProductId(id);

		ProductDto product = new ProductDto();
		BeanUtils.copyProperties(findByProductId, product);

		return ResponseEntity.status(HttpStatus.OK).body(product);

	}

}
