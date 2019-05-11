package com.stock.mvc.bean;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Ligne_Cmd_Client")
public class LigneCmdClient implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@OneToOne
    private Article article;
<<<<<<< HEAD
	private BigDecimal prixUnitaireHT;
	private BigDecimal prixUnitaireTTC;
	private int quantite;
	
	@ManyToOne
    private Administrateur administrateur;
	@ManyToOne
    private CommandeClient commandeClient;
=======

>>>>>>> branch 'master' of https://github.com/MoussaKeita/Gestion_Stock.git
    
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public BigDecimal getPrixUnitaireHT() {
		return prixUnitaireHT;
	}

	public void setPrixUnitaireHT(BigDecimal prixUnitaireHT) {
		this.prixUnitaireHT = prixUnitaireHT;
	}

	public BigDecimal getPrixUnitaireTTC() {
		return prixUnitaireTTC;
	}

	public void setPrixUnitaireTTC(BigDecimal prixUnitaireTTC) {
		this.prixUnitaireTTC = prixUnitaireTTC;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	
	
}
