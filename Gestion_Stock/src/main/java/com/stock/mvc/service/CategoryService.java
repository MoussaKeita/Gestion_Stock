package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Category;

public interface CategoryService {
	
	public Category save(Category entity);
	public Category update(Category entity);
	public List<Category> selectAll();
	public List<Category> selectAll(String sortField, String sort);
	public Category getbyId(Long id);
	public void remove(Long id);
	public Category findOne(String paramName, Object paramValue);
	public Category findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);

}
