package com.ecommerce.ecommerce.dto;

public class Category_response {
	
	private Integer Id;
	
	private String categoryName;
	
	public Category_response() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}



}
