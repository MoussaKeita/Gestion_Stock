package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.BonCommande;
import com.stock.mvc.dao.BonCommandeDao;
import com.stock.mvc.service.BonCommandeService;

@Transactional
public class BonCommandeServiceImpl implements BonCommandeService {
	private BonCommandeDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public BonCommandeDao getDao() {
		return dao;
	}

	public void setDao(BonCommandeDao dao) {
		this.dao = dao;
	}
	

	@Override
	public BonCommande save(BonCommande entity) {
		return dao.save(entity);
	}


	@Override
	public BonCommande update(BonCommande entity) {
		return dao.update(entity);
	}

	@Override
	public List<BonCommande> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<BonCommande> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public BonCommande getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public BonCommande findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public BonCommande findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
