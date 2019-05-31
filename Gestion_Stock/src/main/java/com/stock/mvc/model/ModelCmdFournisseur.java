package com.stock.mvc.model;

import java.util.Collection;
import java.util.Map;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.CommandeFournisseur;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.bean.LigneCmdFournisseur;

public interface ModelCmdFournisseur {
	
	void creerCommande();
	void modifierCommande(Fournisseur fournisseur);
	LigneCmdFournisseur ajouterLigneCmd(Article article);
	LigneCmdFournisseur modifierQuantite(Article article, double quantite);
	LigneCmdFournisseur supprimerLigneCmd(Article article);
    String generateCodeCommande();
    CommandeFournisseur getCommande();
    Map<String, LigneCmdFournisseur> getLigneCmdFournisseur();
    Collection<LigneCmdFournisseur> getLignesCmdFournisseur(CommandeFournisseur commande);
    void init();
	CommandeFournisseur updateCommande(CommandeFournisseur commande);
	void setLigne(String code, LigneCmdFournisseur ligne);
}
