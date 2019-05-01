package com.stock.mvc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article implements Serializable{
           @Id
           @GeneratedValue
           @Column(name="id_Article")
           private Long idArticle;
           private String codeArticle;
           private String libelle;
           private BigDecimal prixUnitaireHT;
           private BigDecimal prixUnitaireTTC;
           private BigDecimal tauxTVA;
           private String photo;
           
           @ManyToOne
           private Category category;
           @ManyToOne
           private BonLivraison bonLivraison;
           @ManyToOne
           private BonCommande bonCommande;
           @OneToOne
           private LigneVente ligneVente;
           @OneToOne
           private LigneCmdClient ligneCmdClient;
           @OneToOne
           private LigneCmdFournisseur ligneCmdFournisseur;
           @ManyToMany
          private List<MouvementStock> MouvementStocks;
           
          public Article() {
        	  
          }


		public Long getIdArticle() {
			return idArticle;
		}

		public void setIdArticle(Long idArticle) {
			this.idArticle = idArticle;
		}

		public String getCodeArticle() {
			return codeArticle;
		}

		public void setCodeArticle(String codeArticle) {
			this.codeArticle = codeArticle;
		}

		public String getLibelle() {
			return libelle;
		}

		public void setLibelle(String libelle) {
			this.libelle = libelle;
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

		public BigDecimal getTauxTVA() {
			return tauxTVA;
		}

		public void setTauxTVA(BigDecimal tauxTVA) {
			this.tauxTVA = tauxTVA;
		}

		public String getPhoto() {
			return photo;
		}

		public void setPhoto(String photo) {
			this.photo = photo;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		public BonLivraison getBonLivraison() {
			return bonLivraison;
		}

		public void setBonLivraison(BonLivraison bonLivraison) {
			this.bonLivraison = bonLivraison;
		}

		public BonCommande getBonCommande() {
			return bonCommande;
		}

		public void setBonCommande(BonCommande bonCommande) {
			this.bonCommande = bonCommande;
		}

		public LigneCmdClient getLigneCmdClient() {
			return ligneCmdClient;
		}

		public void setLigneCmdClient(LigneCmdClient ligneCmdClient) {
			this.ligneCmdClient = ligneCmdClient;
		}

		public LigneVente getLigneVente() {
			return ligneVente;
		}

		public void setLigneVente(LigneVente ligneVente) {
			this.ligneVente = ligneVente;
		}

		public LigneCmdFournisseur getLigneCmdFournisseur() {
			return ligneCmdFournisseur;
		}

		public void setLigneCmdFournisseur(LigneCmdFournisseur ligneCmdFournisseur) {
			this.ligneCmdFournisseur = ligneCmdFournisseur;
		}

		public List<MouvementStock> getMouvementStocks() {
			return MouvementStocks;
		}

		public void setMouvementStocks(List<MouvementStock> mouvementStocks) {
			MouvementStocks = mouvementStocks;
		}
		         
           
}
