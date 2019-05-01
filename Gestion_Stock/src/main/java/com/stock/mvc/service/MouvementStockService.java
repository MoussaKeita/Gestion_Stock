package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.MouvementStock;

public interface MouvementStockService{
	public MouvementStock save(MouvementStock entity);
	public MouvementStock update(MouvementStock entity);
	public List<MouvementStock> selectAll();
	public List<MouvementStock> selectAll(String sortField, String sort);
	public MouvementStock getbyId(Long id);
	public void remove(Long id);
	public MouvementStock findOne(String paramName, Object paramValue);
	public MouvementStock findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}

