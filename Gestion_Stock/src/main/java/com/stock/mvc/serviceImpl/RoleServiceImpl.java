package com.stock.mvc.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Roles;
import com.stock.mvc.dao.RoleDao;
import com.stock.mvc.service.RoleService;

@Transactional
public class RoleServiceImpl implements RoleService {
	private RoleDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public RoleDao getDao() {
		return dao;
	}

	public void setDao(RoleDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Roles save(Roles entity) {
		return dao.save(entity);
	}


	@Override
	public Roles update(Roles entity) {
		return dao.update(entity);
	}

	@Override
	public List<Roles> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Roles> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Roles getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Roles findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Roles findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
