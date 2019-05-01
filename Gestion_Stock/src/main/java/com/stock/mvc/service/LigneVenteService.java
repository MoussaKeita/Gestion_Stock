package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.LigneVente;

public interface LigneVenteService{
	public LigneVente save(LigneVente entity);
	public LigneVente update(LigneVente entity);
	public List<LigneVente> selectAll();
	public List<LigneVente> selectAll(String sortField, String sort);
	public LigneVente getbyId(Long id);
	public void remove(Long id);
	public LigneVente findOne(String paramName, Object paramValue);
	public LigneVente findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}
