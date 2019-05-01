package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.BonLivraison;
import com.stock.mvc.dao.BonLivraisonDao;
import com.stock.mvc.service.BonLivraisonService;

@Transactional
public class BonLivraisonServiceImpl implements BonLivraisonService {
	private BonLivraisonDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public BonLivraisonDao getDao() {
		return dao;
	}

	public void setDao(BonLivraisonDao dao) {
		this.dao = dao;
	}
	

	@Override
	public BonLivraison save(BonLivraison entity) {
		return dao.save(entity);
	}


	@Override
	public BonLivraison update(BonLivraison entity) {
		return dao.update(entity);
	}

	@Override
	public List<BonLivraison> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<BonLivraison> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public BonLivraison getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public BonLivraison findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public BonLivraison findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
