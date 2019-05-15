package com.stock.mvc.model;

import java.math.BigDecimal;
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
	public void creerCommande(Fournisseur fournisseur) {
		if(fournisseur==null) {
			return ;
		}
		commande = new CommandeFournisseur();
		commande.setFournisseur(fournisseur);
		commande.setDateCommande(new Date());
		commande.setCode(generateCodeCommande());
		
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
		}else {
			LigneCmdFournisseur ligne = new LigneCmdFournisseur();
			ligne.setCommandeFournisseur(commande);
			ligne.setQuantite(BigDecimal.ONE);
			ligne.setPrixUnitaireTTC(article.getPrixUnitaireTTC());
			ligne.setArticle(article);
			ligneCmdFournisseur.put(article.getCode() ,ligne);
			return ligne;
		}
		return null;
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
