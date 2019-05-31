package com.stock.mvc.dao.impl;

import java.util.List;

import javax.persistence.Query;
import com.stock.mvc.bean.LigneVente;
import com.stock.mvc.dao.LigneVenteDao;

public class LigneVenteDaoImpl extends GenericDaoImpl<LigneVente> implements LigneVenteDao {

	@Override
	public List<LigneVente> getbyCodeCommande(String code) {
		String queryString ="select lc from " + LigneVente.class.getSimpleName() + " lc where lc.vente.code = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", code);
		return query.getResultList();
	}

}
