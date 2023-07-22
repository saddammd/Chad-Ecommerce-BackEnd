package com.ecommerce.ecommerce.dto;

import org.springframework.data.domain.Page;

public class PageDto {

	private int pageNumber;
	private int pageSize;
	private Integer categoryId;
	
	
	public PageDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Page getPagedto(int pageNumber, int pageSize, Integer categoryId) {
		this.categoryId = categoryId;
		this.pageNumber = pageNumber;
		this.pageSize = pageSize;
		
		Page p = (Page) new PageDto();
		
		return p;
	}

	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public Integer getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	
	
	
}
