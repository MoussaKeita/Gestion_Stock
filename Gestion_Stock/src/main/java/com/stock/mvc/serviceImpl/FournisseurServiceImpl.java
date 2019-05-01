package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.dao.FournisseurDao;
import com.stock.mvc.service.FournisseurService;

@Transactional
public class FournisseurServiceImpl implements FournisseurService {
	private FournisseurDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public FournisseurDao getDao() {
		return dao;
	}

	public void setDao(FournisseurDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Fournisseur save(Fournisseur entity) {
		return dao.save(entity);
	}


	@Override
	public Fournisseur update(Fournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Fournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Fournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Fournisseur getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
    public Fournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Fournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

