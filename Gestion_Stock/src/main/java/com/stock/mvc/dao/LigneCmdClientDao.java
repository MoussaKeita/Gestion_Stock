package com.stock.mvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;

@Repository
public interface LigneCmdClientDao extends IGenericDao<LigneCmdClient>{

	List<LigneCmdClient> getbyCodeCommande(String code);


}
