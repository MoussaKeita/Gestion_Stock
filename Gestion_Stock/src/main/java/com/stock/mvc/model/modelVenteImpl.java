package com.stock.mvc.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.CommandeClient;
//import com.stock.mvc.bean.LigneVente;
import com.stock.mvc.bean.Vente;


@Component
public class modelVenteImpl implements ModelVente {
	
	private Vente vente;
	//private Map<String, LigneVente> ligneVente= new HashMap<String ,LigneVente>();
	@Override
	public void creerVente() {
		vente = new Vente();
		vente.setDateVente(new Date());;
		vente.setCode(generateCodeCommande());	
	}
	@Override
	public void modifierVente(CommandeClient commandeClient) {
		if(commandeClient ==null) {
			return;
		}
		if(commandeClient !=null) {
		vente.setCommandeClient(commandeClient);
		}
	}
	@Override
	public Vente updateVente(Vente oldvente) {
		vente = oldvente;
		return vente;
	}
	/*@Override
	public LigneVente ajouterLigneVente(Article article) {
		if(article==null) {
			return null;
		}
		LigneVente lc = ligneVente.get(article.getCode());
		if(lc!=null) {
			BigDecimal quantite = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(quantite);
			ligneVente.put(article.getCode() ,lc);
			return lc;
		}else {
			LigneVente  ligne = new LigneVente ();
			ligne.setVente(vente);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaireTTC(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneVente.put(article.getCode() ,ligne);
			return ligne;
		}
	}
	@Override
	public LigneVente modifierQuantite(Article article, double quantite) {
		if(article==null) {
			return null;
		}
		LigneVente lc = ligneVente.get(article.getCode());
		if(lc==null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(quantite));
		return lc;
	}
	@Override
	public LigneVente supprimerLigneVente(Article article) {
		if(article==null) {
			return null;
		}
		return ligneVente.remove(article.getCode());
	}*/
	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	@Override
	public Vente getCommande() {
		
		return vente;
	}
	/*@Override
	public Map<String, LigneVente> getLigneVente() {
		return ligneVente;
	}
	@Override
	public Collection<LigneVente> getLignesVente(Vente vente) {
		for(LigneVente ligneV : ligneVente.values()) {
			ligneV.setVente(vente);
	     }
		return ligneVente.values();
	}
	@Override
	public void init() {
		vente=null;
		ligneVente.clear();
	}
	@Override
	public void setLigne(String code, LigneVente ligneVente) {
		this.ligneVente.put(code, ligneVente);
		
	}
*/
}
