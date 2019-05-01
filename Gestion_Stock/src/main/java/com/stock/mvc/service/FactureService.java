package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Facture;

public interface FactureService{
	public Facture save(Facture entity);
	public Facture update(Facture entity);
	public List<Facture> selectAll();
	public List<Facture> selectAll(String sortField, String sort);
	public Facture getbyId(Long id);
	public void remove(Long id);
	public Facture findOne(String paramName, Object paramValue);
	public Facture findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}