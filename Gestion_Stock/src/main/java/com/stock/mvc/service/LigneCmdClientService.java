package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;

public interface LigneCmdClientService{
	public LigneCmdClient save(LigneCmdClient entity);
	public LigneCmdClient update(LigneCmdClient entity);
	public List<LigneCmdClient> selectAll();
	public List<LigneCmdClient> selectAll(String sortField, String sort);
	public LigneCmdClient getbyId(Long id);
	public LigneCmdClient getbyCodeCommandeClient(String code);	
	public void remove(Long id);
	public LigneCmdClient findOne(String paramName, Object paramValue);
	public LigneCmdClient findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);
}

