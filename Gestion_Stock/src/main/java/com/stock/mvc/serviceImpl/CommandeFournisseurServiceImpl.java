package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.CommandeFournisseur;
import com.stock.mvc.dao.CommandeFournisseurDao;
import com.stock.mvc.service.CommandeFournisseurService;

@Transactional
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {
	private CommandeFournisseurDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public CommandeFournisseurDao getDao() {
		return dao;
	}

	public void setDao(CommandeFournisseurDao dao) {
		this.dao = dao;
	}
	

	@Override
	public CommandeFournisseur save(CommandeFournisseur entity) {
		return dao.save(entity);
	}


	@Override
	public CommandeFournisseur update(CommandeFournisseur entity) {
		return dao.update(entity);
	}

	@Override
	public List<CommandeFournisseur> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<CommandeFournisseur> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CommandeFournisseur getbyId(Long id) {
		return dao.getbyId(id);
	}
	@Override
	public CommandeFournisseur getbyCode(String code) {
		
		return dao.getbyCode(code);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}
	@Override
	public void remove(String code) {
		dao.remove(code);
		
	}

	@Override
	public CommandeFournisseur findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeFournisseur findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}

