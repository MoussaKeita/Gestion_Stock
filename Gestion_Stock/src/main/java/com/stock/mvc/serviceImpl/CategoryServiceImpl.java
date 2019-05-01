package com.stock.mvc.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Category;
import com.stock.mvc.dao.CategoryDao;
import com.stock.mvc.service.CategoryService;

@Transactional
public class CategoryServiceImpl implements CategoryService {
	private CategoryDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public CategoryDao getDao() {
		return dao;
	}

	public void setDao(CategoryDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Category save(Category entity) {
		return dao.save(entity);
	}


	@Override
	public Category update(Category entity) {
		return dao.update(entity);
	}

	@Override
	public List<Category> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Category> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Category getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Category findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Category findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
