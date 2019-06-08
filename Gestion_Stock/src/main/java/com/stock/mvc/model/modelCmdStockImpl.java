package com.stock.mvc.model;


import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.stock.mvc.bean.MouvementStock;

@Component
public class modelCmdStockImpl implements ModelCmdStock {
	
	private MouvementStock stock;

	@Override
	public void creerCommande(){
		stock = new MouvementStock();
		stock.setDate(new Date());
		stock.setQuantiteRestante(stock.getQuantiteRestante());
		stock.setQuantiteLivre(stock.getQuantiteLivre());
		stock.setQuantiteSortie(stock.getQuantiteSortie());

	}
	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}

	
	@Override
	public  MouvementStock getCommande() {
		return stock ;
	}
	/*
	@Override
	public MouvementStock getCommande() {
		return commande;
	}*/
	/*
	@Override
	public void modifierCommande(Client Client) {
		if(Client==null) {
			return;
		}
		if(Client !=null) {
			commande.setClient(Client);
		}
	}
	
	@Override
	public LigneCmdClient ajouterLigneCmd(Article article) {
		if(article==null) {
			return null;
		}
		LigneCmdClient lc = ligneCmdClient.get(article.getCode());
		if(lc!=null) {
			BigDecimal quantite = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(quantite);
			ligneCmdClient.put(article.getCode() ,lc);
			return lc;
		}else {
			LigneCmdClient ligne = new LigneCmdClient();
			ligne.setCommandeClient(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaireTTC(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneCmdClient.put(article.getCode() ,ligne);
			return ligne;
		}
	
	}

	@Override
	public LigneCmdClient modifierQuantite(Article article, double quantite) {
		if(article==null) {
			return null;
		}
		LigneCmdClient lc = ligneCmdClient.get(article.getCode());
		if(lc==null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(quantite));
		return lc;
	}
	@Override
	public Collection<LigneCmdClient> getLignesCmdClient(CommandeClient commande) {
	     for(LigneCmdClient ligneCmdFournis : ligneCmdClient.values()) {
	    	 ligneCmdFournis.setCommandeClient(commande);
	     }
		return ligneCmdClient.values();
	}
	
	@Override
	public LigneCmdClient supprimerLigneCmd(Article article) {
		if(article==null) {
			return null;
		}
		return ligneCmdClient.remove(article.getCode());
	}

	public void setCommande(CommandeClient commande) {
		this.commande = commande;
	}
	@Override
	public Map<String, LigneCmdClient> getLigneCmdClient() {
		return ligneCmdClient;
	}

	public void setLigneCmdClient(Map<String, LigneCmdClient> ligneCmdClient) {
		this.ligneCmdClient = ligneCmdClient;
	}
*/

}
