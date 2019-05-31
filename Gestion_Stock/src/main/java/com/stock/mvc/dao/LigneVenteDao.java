package com.stock.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.mvc.bean.LigneVente;

@Repository
public interface LigneVenteDao extends IGenericDao<LigneVente>{
	public List<LigneVente> getbyCodeCommande(String code);

}
