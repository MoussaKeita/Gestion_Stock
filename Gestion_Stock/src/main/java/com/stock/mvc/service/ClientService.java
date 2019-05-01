package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Client;

public interface ClientService {
	
	public Client save(Client entity);
	public Client update(Client entity);
	public List<Client> selectAll();
	public List<Client> selectAll(String sortField, String sort);
	public Client getbyId(Long id);
	public void remove(Long id);
	public Client findOne(String paramName, Object paramValue);
	public Client findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);

}
