package com.stock.mvc.serviceImpl;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.stock.mvc.bean.Client;
import com.stock.mvc.dao.ClientDao;
import com.stock.mvc.service.ClientService;

@Transactional
public class ClientServiceImpl implements ClientService {
	private ClientDao dao ;
	// getter and setter pour pouvoir faire l'injection de dependance//
	public ClientDao getDao() {
		return dao;
	}

	public void setDao(ClientDao dao) {
		this.dao = dao;
	}
	

	@Override
	public Client save(Client entity) {
		return dao.save(entity);
	}


	@Override
	public Client update(Client entity) {
		return dao.update(entity);
	}

	@Override
	public List<Client> selectAll() {
		return dao.selectAll();
	}

	@Override
	public List<Client> selectAll(String sortField, String sort) {
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Client getbyId(Long id) {
		return dao.getbyId(id);
	}

	@Override
	public void remove(Long id) {
		dao.remove(id);
	}

	@Override
	public Client findOne(String paramName, Object paramValue) {
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Client findOne(String[] paramNames, Object[] paramValues) {
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, Object paramValue) {
		return dao.findCountBy(paramName, paramValue);
	}

}
