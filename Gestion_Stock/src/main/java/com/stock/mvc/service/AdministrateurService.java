package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Administrateur;

public interface AdministrateurService{
	public Administrateur save(Administrateur entity);
	public Administrateur update(Administrateur entity);
	public List<Administrateur> selectAll();
	public List<Administrateur> selectAll(String sortField, String sort);
	public Administrateur getbyId(Long id);
	public void remove(Long id);
	public Administrateur findOne(String paramName, Object paramValue);
	public Administrateur findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}
