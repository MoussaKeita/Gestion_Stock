package com.stock.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.mvc.bean.LigneCmdFournisseur;

@Repository
public interface LigneCmdFournisseurDao extends IGenericDao<LigneCmdFournisseur>{
	public List<LigneCmdFournisseur> getbyIdCommande(Long idCmdFournisseur);
	public List<LigneCmdFournisseur> getbyCodeCommande(String code);

}
