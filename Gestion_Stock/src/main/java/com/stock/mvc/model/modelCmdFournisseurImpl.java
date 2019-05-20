package com.stock.mvc.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.CommandeFournisseur;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.bean.LigneCmdFournisseur;

@Component
public class modelCmdFournisseurImpl implements ModelCmdFournisseur {
	
	private CommandeFournisseur commande;
	private Map<String, LigneCmdFournisseur> ligneCmdFournisseur = new HashMap<String ,LigneCmdFournisseur>();
	
	@Override
	public void init() {
		commande=null;
		ligneCmdFournisseur.clear();
	}

	@Override
	public void creerCommande(){
		commande = new CommandeFournisseur();
		commande.setDateCommande(new Date());
		commande.setCode(generateCodeCommande());	
	}
	
	@Override
	public void modifierCommande(Fournisseur fournisseur) {
		if(fournisseur==null) {
			return;
		}
		if(fournisseur !=null) {
			commande.setFournisseur(fournisseur);
		}
	}
	
	@Override
	public LigneCmdFournisseur ajouterLigneCmd(Article article) {
		if(article==null) {
			return null;
		}
		LigneCmdFournisseur lc = ligneCmdFournisseur.get(article.getCode());
		if(lc!=null) {
			BigDecimal quantite = lc.getQuantite().add(BigDecimal.ONE);
			lc.setQuantite(quantite);
			ligneCmdFournisseur.put(article.getCode() ,lc);
			return lc;
		}else {
			LigneCmdFournisseur ligne = new LigneCmdFournisseur();
			ligne.setCommandeFournisseur(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaireTTC(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneCmdFournisseur.put(article.getCode() ,ligne);
			return ligne;
		}
	
	}

	@Override
	public LigneCmdFournisseur modifierQuantite(Article article, double quantite) {
		if(article==null) {
			return null;
		}
		LigneCmdFournisseur lc = ligneCmdFournisseur.get(article.getCode());
		if(lc==null) {
			return null;
		}
		lc.setQuantite(BigDecimal.valueOf(quantite));
		return lc;
	}
	@Override
	public Collection<LigneCmdFournisseur> getLignesCmdFournisseur(CommandeFournisseur commande) {
	     for(LigneCmdFournisseur ligneCmdFournis : ligneCmdFournisseur.values()) {
	    	 ligneCmdFournis.setCommandeFournisseur(commande);
	     }
		return ligneCmdFournisseur.values();
	}
	
	@Override
	public LigneCmdFournisseur supprimerLigneCmd(Article article) {
		if(article==null) {
			return null;
		}
		return ligneCmdFournisseur.remove(article.getCode());
	}

	@Override
	public String generateCodeCommande() {
		return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
	}
	@Override
	public CommandeFournisseur getCommande() {
		return commande;
	}

	public void setCommande(CommandeFournisseur commande) {
		this.commande = commande;
	}
	@Override
	public Map<String, LigneCmdFournisseur> getLigneCmdFournisseur() {
		return ligneCmdFournisseur;
	}

	public void setLigneCmdFournisseur(Map<String, LigneCmdFournisseur> ligneCmdFournisseur) {
		this.ligneCmdFournisseur = ligneCmdFournisseur;
	}

}
