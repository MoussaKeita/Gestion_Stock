package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.Vente;

public interface CommandeClientService{
	public CommandeClient save(CommandeClient entity);
	public CommandeClient update(CommandeClient entity);
	public List<CommandeClient> selectAll();
	public List<CommandeClient> selectAll(String sortField, String sort);
	public CommandeClient getbyCode(String code);
	public void remove(Long id);
	public CommandeClient findOne(String paramName, Object paramValue);
	public CommandeClient findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
	public void remove(String code);
}

