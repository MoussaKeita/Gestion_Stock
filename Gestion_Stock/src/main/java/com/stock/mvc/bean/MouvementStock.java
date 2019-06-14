package com.stock.mvc.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "mouvementStock")
public class MouvementStock implements Serializable{
	/*public static final int ENTREE =1;
	public static final int SORTIE =-1;*/
    @Id
    @GeneratedValue
    @Column(name="id")
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd") 
    private Date date;
    private BigDecimal quantiteRestante;
    private BigDecimal quantiteLivre;
    private BigDecimal quantiteSortie;
 
    @ManyToOne
	@JoinColumn(name="code_Article")
    private Article article;
    @ManyToOne
    private Fournisseur fournisseur;
   
    public MouvementStock() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	

	public BigDecimal getQuantiteRestante() {
		return quantiteRestante;
	}

	public void setQuantiteRestante(BigDecimal quantiteRestante) {
		this.quantiteRestante = quantiteRestante;
	}

	public BigDecimal getQuantiteLivre() {
		return quantiteLivre;
	}

	public void setQuantiteLivre(BigDecimal quantiteLivre) {
		this.quantiteLivre = quantiteLivre;
	}

	public BigDecimal getQuantiteSortie() {
		return quantiteSortie;
	}

	public void setQuantiteSortie(BigDecimal quantiteSortie) {
		this.quantiteSortie = quantiteSortie;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	
	   
}
