package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.BonCommande;

public interface BonCommandeService{
	public BonCommande save(BonCommande entity);
	public BonCommande update(BonCommande entity);
	public List<BonCommande> selectAll();
	public List<BonCommande> selectAll(String sortField, String sort);
	public BonCommande getbyId(Long id);
	public void remove(Long id);
	public BonCommande findOne(String paramName, Object paramValue);
	public BonCommande findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}
