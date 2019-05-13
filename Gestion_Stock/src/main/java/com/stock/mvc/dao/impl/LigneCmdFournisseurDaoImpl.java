package com.stock.mvc.dao.impl;

import java.util.List;

import javax.persistence.Query;

import com.stock.mvc.bean.LigneCmdFournisseur;
import com.stock.mvc.dao.LigneCmdFournisseurDao;

public class LigneCmdFournisseurDaoImpl extends GenericDaoImpl<LigneCmdFournisseur> implements LigneCmdFournisseurDao {

	@Override
	public List<LigneCmdFournisseur> getbyIdCommande(Long idCmdFournisseur) {
		String queryString ="select lc from " + LigneCmdFournisseur.class.getSimpleName() + " lc where lc.commandeFournisseur.idCmdFournisseur = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", idCmdFournisseur);
		return query.getResultList();
	}

	@Override
	public List<LigneCmdFournisseur> getbyCodeCommande(String code) {
		String queryString ="select lc from " + LigneCmdFournisseur.class.getSimpleName() + " lc where lc.commandeFournisseur.code = :x";
		Query query = em.createQuery(queryString);
		query.setParameter("x", code);
		return query.getResultList();
		
	}

}
