package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.BonLivraison;

public interface BonLivraisonService{
	public BonLivraison save(BonLivraison entity);
	public BonLivraison update(BonLivraison entity);
	public List<BonLivraison> selectAll();
	public List<BonLivraison> selectAll(String sortField, String sort);
	public BonLivraison getbyId(Long id);
	public void remove(Long id);
	public BonLivraison findOne(String paramName, Object paramValue);
	public BonLivraison findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}

