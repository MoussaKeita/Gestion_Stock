package com.stock.mvc.service;

import java.util.List;

import com.stock.mvc.bean.Roles;

public interface RoleService {
	
	public Roles save(Roles entity);
	public Roles update(Roles entity);
	public List<Roles> selectAll();
	public List<Roles> selectAll(String sortField, String sort);
	public Roles getbyId(Long id);
	public void remove(Long id);
	public Roles findOne(String paramName, Object paramValue);
	public Roles findOne(String[] paramName, Object[] paramValue);
	public int findCountBy(String paramNames, Object paramValues);

}
