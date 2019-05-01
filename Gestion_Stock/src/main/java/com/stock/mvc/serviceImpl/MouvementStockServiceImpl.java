package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.MouvementStock;
import com.stock.mvc.dao.MouvementStockDao;
import com.stock.mvc.service.MouvementStockService;

@Transactional
public class MouvementStockServiceImpl implements MouvementStockService {
	private MouvementStockDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public MouvementStockDao getDao() {
		return dao;
	}

	public void setDao(MouvementStockDao dao) {
		this.dao = dao;
	}
	

	@Override
	public MouvementStock save(MouvementStock entity) {
		return dao.save(entity);
	}


	@Override
	public MouvementStock update(MouvementStock entity) {
		return dao.update(entity);
	}

	@Override
	public List<MouvementStock> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<MouvementStock> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public MouvementStock getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public MouvementStock findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public MouvementStock findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
