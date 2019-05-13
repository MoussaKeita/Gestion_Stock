package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.LigneCmdFournisseur;
import com.stock.mvc.dao.LigneCmdFournisseurDao;
import com.stock.mvc.service.LigneCmdFournisseurService;

@Transactional
public class LigneCmdFournisseurServiceImpl implements LigneCmdFournisseurService {
	private LigneCmdFournisseurDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public LigneCmdFournisseurDao getDao() {
		return dao;
	}

	public void setDao(LigneCmdFournisseurDao dao) {
		this.dao = dao;
	}
	

	@Override
	public LigneCmdFournisseur save(LigneCmdFournisseur entity) {
		return dao.save(entity);
	}


	@Override
	public LigneCmdFournisseur update(LigneCmdFournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<LigneCmdFournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneCmdFournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneCmdFournisseur getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public LigneCmdFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCmdFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}
	@Override
	public List<LigneCmdFournisseur> getbyIdCommande(Long idCmdFournisseur) {
		
		return dao.getbyIdCommande(idCmdFournisseur);
	}

	@Override
	public List<LigneCmdFournisseur> getbyCodeCommande(String code) {
		
		return dao.getbyCodeCommande(code);
	}



}

