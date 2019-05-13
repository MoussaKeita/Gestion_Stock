package com.stock.mvc.bean;
import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Ligne_Cmd_Fournisseur")
public class LigneCmdFournisseur implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne
    @JoinColumn(name="code_Article")
    private Article article;
    
	@ManyToOne
	@JoinColumn(name="code_CmdFournisseur")
    private CommandeFournisseur commandeFournisseur;
	
	private BigDecimal quantite;
	private BigDecimal prixUnitaire;
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	//@JsonIgnore
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}
@JsonIgnore
	public CommandeFournisseur getCommandeFournisseur() {
		return commandeFournisseur;
	}

	public void setCommandeFournisseur(CommandeFournisseur commandeFournisseur) {
		this.commandeFournisseur = commandeFournisseur;
	}

	public BigDecimal getQuantite() {
		return quantite;
	}

	public void setQuantite(BigDecimal quantite) {
		this.quantite = quantite;
	}

	public BigDecimal getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(BigDecimal prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}
	
	
}