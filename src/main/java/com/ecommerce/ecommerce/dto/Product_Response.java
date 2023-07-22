package com.ecommerce.ecommerce.dto;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class Product_Response {

	private Map<?, ?> data;
	private HttpStatus status;
	private String message;
	private Long timestamp;
	
	
	
	
	public Product_Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Map<?, ?> getData() {
		return data;
	}
	public void setData(Map<?, ?> data) {
		this.data = data;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long l) {
		this.timestamp = l;
	}
	
	

}
