package com.ecommerce.ecommerce.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.ecommerce.ecommerce.exceptions.productNotFoundException;
import com.ecommerce.ecommerce.exceptions.InvalidPageException;
import com.ecommerce.ecommerce.exceptions.ProductErrorResponse;

@ControllerAdvice
public class Products_Exception_Handlers {
	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleInvalidPage(InvalidPageException ex){
		
		ProductErrorResponse response = new ProductErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ProductErrorResponse> handleProductNotFound(productNotFoundException ex){
		
		ProductErrorResponse response = new ProductErrorResponse();
		response.setMessage(ex.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

}
