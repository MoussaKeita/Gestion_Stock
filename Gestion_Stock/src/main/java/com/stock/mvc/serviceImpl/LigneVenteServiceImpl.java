/*package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.LigneVente;
import com.stock.mvc.dao.LigneVenteDao;
import com.stock.mvc.service.LigneVenteService;

@Transactional
public class LigneVenteServiceImpl implements LigneVenteService {
	private LigneVenteDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public LigneVenteDao getDao() {
		return dao;
	}

	public void setDao(LigneVenteDao dao) {
		this.dao = dao;
	}
	

	@Override
	public LigneVente save(LigneVente entity) {
		return dao.save(entity);
	}


	@Override
	public LigneVente update(LigneVente entity) {
		return dao.update(entity);
	}

	@Override
	public List<LigneVente> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneVente> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneVente getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public LigneVente findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneVente findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public List<LigneVente> getbyCodeCommande(String code) {
		return dao.getbyCodeCommande(code);
	}

}
*/