package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.LigneCmdFournisseur;

public interface LigneCmdFournisseurService{
	public LigneCmdFournisseur save(LigneCmdFournisseur entity);
	public LigneCmdFournisseur update(LigneCmdFournisseur entity);
	public List<LigneCmdFournisseur> selectAll();
	public List<LigneCmdFournisseur> selectAll(String sortField, String sort);
	public LigneCmdFournisseur getbyId(Long id);
	public void remove(Long id);
	public LigneCmdFournisseur findOne(String paramName, Object paramValue);
	public LigneCmdFournisseur findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}

