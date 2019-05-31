package com.stock.mvc.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Utilisateur;
import com.stock.mvc.dao.UtilisateurDao;
import com.stock.mvc.service.UtilisateurService;

@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	private UtilisateurDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public UtilisateurDao getDao() {
		return dao;
	}

	public void setDao(UtilisateurDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Utilisateur save(Utilisateur entity) {
		return dao.save(entity);
	}


	@Override
	public Utilisateur update(Utilisateur entity) {
		return dao.update(entity);
	}

	@Override
	public List<Utilisateur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Utilisateur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Utilisateur getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Utilisateur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Utilisateur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
