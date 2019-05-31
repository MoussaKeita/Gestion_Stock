package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Utilisateur;

public interface UtilisateurService {
	
	public Utilisateur save(Utilisateur entity);
	public Utilisateur update(Utilisateur entity);
	public List<Utilisateur> selectAll();
	public List<Utilisateur> selectAll(String sortField, String sort);
	public Utilisateur getbyId(Long id);
	public void remove(Long id);
	public Utilisateur findOne(String paramName, Object paramValue);
	public Utilisateur findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);

}
