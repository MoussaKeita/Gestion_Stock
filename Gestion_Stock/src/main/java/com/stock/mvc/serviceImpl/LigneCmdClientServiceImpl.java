package com.stock.mvc.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;
import com.stock.mvc.dao.LigneCmdClientDao;
import com.stock.mvc.service.CommandeClientService;
import com.stock.mvc.service.LigneCmdClientService;

@Transactional
public class LigneCmdClientServiceImpl implements LigneCmdClientService {
	private LigneCmdClientDao dao ;
	private CommandeClient cmd;
	@Autowired
	private CommandeClientService cmdService;
	
	// getter and setter pour pouvoir faire l'injection de dependance//
	public LigneCmdClientDao getDao() {
		return dao;
	}

	public void setDao(LigneCmdClientDao dao) {
		this.dao = dao;
	}
	

	@Override
	public LigneCmdClient save(LigneCmdClient entity) {
		return dao.save(entity);
	}


	@Override
	public LigneCmdClient update(LigneCmdClient entity) {
		return dao.update(entity);
	}

	@Override
	public List<LigneCmdClient> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<LigneCmdClient> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public LigneCmdClient getbyId(Long id) {
		return dao.getbyId(id);
	}
	
	@Override
	public LigneCmdClient getbyCodeCommandeClient(String code) {
		// TODO Auto-generated method stub
		cmd= cmdService.getbyCode(code);
		return dao.getbyCode(code);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public LigneCmdClient findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public LigneCmdClient findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

	

}

