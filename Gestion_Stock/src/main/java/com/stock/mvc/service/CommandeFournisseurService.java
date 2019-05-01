package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.CommandeFournisseur;

public interface CommandeFournisseurService{
	public CommandeFournisseur save(CommandeFournisseur entity);
	public CommandeFournisseur update(CommandeFournisseur entity);
	public List<CommandeFournisseur> selectAll();
	public List<CommandeFournisseur> selectAll(String sortField, String sort);
	public CommandeFournisseur getbyId(Long id);
	public void remove(Long id);
	public CommandeFournisseur findOne(String paramName, Object paramValue);
	public CommandeFournisseur findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}
