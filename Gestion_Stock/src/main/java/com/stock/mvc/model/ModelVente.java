package com.stock.mvc.model;

import com.stock.mvc.bean.CommandeClient;
//import com.stock.mvc.bean.LigneVente;
import com.stock.mvc.bean.Vente;

public interface ModelVente {
	
	void creerVente();
	void modifierVente(CommandeClient commandeClient);
	//LigneVente ajouterLigneVente(Article article);
	//LigneVente modifierQuantite(Article article, double quantite);
	//LigneVente supprimerLigneVente(Article article);
    String generateCodeCommande();
    Vente getCommande();
   // Map<String, LigneVente> getLigneVente();
  //  Collection<LigneVente> getLignesVente(Vente vente);
  //  void init();
    Vente updateVente(Vente vente);
	//void setLigne(String code, LigneVente ligne);
}
