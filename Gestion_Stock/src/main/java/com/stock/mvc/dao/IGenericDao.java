package com.stock.mvc.dao;

import java.util.List;

public interface IGenericDao<E> {//pour designer que c'est une interface generique//
	
	public E save(E entity);
	public E update(E entity);
	public List<E> selectAll();
	public List<E> selectAll(String sortField, String sort);
	public E getbyId(Long id);
	public void remove(Long id);
	public E findOne(String paramName, Object paramValue);
	public E findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramName, Object paramValue);
	public E getbyCode(String code);
	public void removebyCode(String code);

}
