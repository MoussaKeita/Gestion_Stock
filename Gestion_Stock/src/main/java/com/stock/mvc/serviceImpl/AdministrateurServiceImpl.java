package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Administrateur;
import com.stock.mvc.dao.AdministrateurDao;
import com.stock.mvc.service.AdministrateurService;

@Transactional
public class AdministrateurServiceImpl implements AdministrateurService {
	private AdministrateurDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public AdministrateurDao getDao() {
		return dao;
	}

	public void setDao(AdministrateurDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Administrateur save(Administrateur entity) {
		return dao.save(entity);
	}


	@Override
	public Administrateur update(Administrateur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Administrateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Administrateur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Administrateur getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Administrateur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Administrateur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
