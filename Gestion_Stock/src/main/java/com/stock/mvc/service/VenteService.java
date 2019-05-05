package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Vente;

public interface VenteService{
	public Vente save(Vente entity);
	public Vente update(Vente entity);
	public List<Vente> selectAll();
	public List<Vente> selectAll(String sortField, String sort);
	public Vente getbyId(Long id);
	public void remove(Long id);
	public Vente findOne(String paramName, Object paramValue);
	public Vente findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
	public Vente getbyCode(String code);
	public void removebyCode(String code);
}

