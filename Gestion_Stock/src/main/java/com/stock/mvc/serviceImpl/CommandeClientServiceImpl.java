package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.Vente;
import com.stock.mvc.dao.CommandeClientDao;
import com.stock.mvc.service.CommandeClientService;

@Transactional
public class CommandeClientServiceImpl implements CommandeClientService {
	private CommandeClientDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public CommandeClientDao getDao() {
		return dao;
	}

	public void setDao(CommandeClientDao dao) {
		this.dao = dao;
	}
	

	@Override
	public CommandeClient save(CommandeClient entity) {
		return dao.save(entity);
	}


	@Override
	public CommandeClient update(CommandeClient entity) {
		return dao.update(entity);
	}

	@Override
	public List<CommandeClient> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<CommandeClient> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public CommandeClient getbyCode(String code) {
		return dao.getbyCode(code);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public CommandeClient findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public CommandeClient findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	@Override
	public void removebyCode(String code) {
		// TODO Auto-generated method stub
		dao.removebyCode(code);
	}
	
}
