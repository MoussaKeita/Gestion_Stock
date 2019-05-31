package com.stock.mvc.model;

import java.util.Collection;
import java.util.Map;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.LigneCmdClient;

public interface ModelCmdClient {
	
	void creerCommande();
	void modifierCommande(Client Client);
	LigneCmdClient ajouterLigneCmd(Article article);
	LigneCmdClient modifierQuantite(Article article, double quantite);
	LigneCmdClient supprimerLigneCmd(Article article);
    String generateCodeCommande();
    CommandeClient getCommande();
    Map<String, LigneCmdClient> getLigneCmdClient();
    Collection<LigneCmdClient> getLignesCmdClient(CommandeClient commande);
    void init();
	CommandeClient updateCommande(CommandeClient commande);
	void setLigne(String code, LigneCmdClient ligne);
}
