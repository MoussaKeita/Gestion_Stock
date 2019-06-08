package com.stock.mvc.model;

import com.stock.mvc.bean.MouvementStock;

public interface ModelCmdStock {
	
	void creerCommande();
	 String generateCodeCommande();
	 MouvementStock getCommande();/*
	void modifierCommande(Client Client);
	LigneCmdClient ajouterLigneCmd(Article article);
	LigneCmdClient modifierQuantite(Article article, double quantite);
	LigneCmdClient supprimerLigneCmd(Article article);
    Map<String, LigneCmdClient> getLigneCmdClient();
    Collection<LigneCmdClient> getLignesCmdClient(CommandeClient commande);
    void init();
	CommandeClient updateCommande(CommandeClient commande);
	void setLigne(String code, LigneCmdClient ligne);*/
}
