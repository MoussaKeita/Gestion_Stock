package com.stock.mvc.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;
import com.stock.mvc.dao.LigneCmdClientDao;

public class LigneCmdClientDaoImpl extends GenericDaoImpl<LigneCmdClient> implements LigneCmdClientDao {

	@Override
	public List<LigneCmdClient> getbyCodeCommande(String code) {
		String queryString ="select lc from " + LigneCmdClient.class.getSimpleName() + " lc where lc.commandeClient.code = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", code);
		return query.getResultList();
		
	}

}
