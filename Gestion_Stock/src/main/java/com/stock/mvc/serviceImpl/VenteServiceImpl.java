package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Vente;
import com.stock.mvc.dao.VenteDao;
import com.stock.mvc.service.VenteService;

@Transactional
public class VenteServiceImpl implements VenteService {
	private VenteDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public VenteDao getDao() {
		return dao;
	}

	public void setDao(VenteDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Vente save(Vente entity) {
		return dao.save(entity);
	}


	@Override
	public Vente update(Vente entity) {
		return dao.update(entity);
	}

	@Override
	public List<Vente> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Vente> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Vente getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Vente findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Vente findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public Vente getbyCode(String code) {
		// TODO Auto-generated method stub
		return dao.getbyCode(code);
	}

	@Override
	public void removebyCode(String code) {
		// TODO Auto-generated method stub
		dao.removebyCode(code);
	}

}
