package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Fournisseur;

public interface FournisseurService{
	public Fournisseur save(Fournisseur entity);
	public Fournisseur update(Fournisseur entity);
	public List<Fournisseur> selectAll();
	public List<Fournisseur> selectAll(String sortField, String sort);
	public Fournisseur getbyId(Long id);
	public void remove(Long id);
	public Fournisseur findOne(String paramName, Object paramValue);
	public Fournisseur findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}

