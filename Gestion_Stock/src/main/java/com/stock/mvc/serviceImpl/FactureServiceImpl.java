package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Facture;
import com.stock.mvc.dao.FactureDao;
import com.stock.mvc.service.FactureService;

@Transactional
public class FactureServiceImpl implements FactureService {
	private FactureDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public FactureDao getDao() {
		return dao;
	}

	public void setDao(FactureDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Facture save(Facture entity) {
		return dao.save(entity);
	}


	@Override
	public Facture update(Facture entity) {
		return dao.update(entity);
	}

	@Override
	public List<Facture> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Facture> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Facture getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Facture findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Facture findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}