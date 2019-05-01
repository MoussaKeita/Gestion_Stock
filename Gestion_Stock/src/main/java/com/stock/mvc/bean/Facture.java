package com.stock.mvc.bean;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Facture")
public class Facture implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private Date dateFacturation;
	private double total;
	private Date datePaiement;
	@OneToMany(mappedBy = "facture")
    private List<BonCommande> bonCommandes;
	@ManyToOne
    private Administrateur administrateur;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateFacturation() {
		return dateFacturation;
	}
	public void setDateFacturation(Date dateFacturation) {
		this.dateFacturation = dateFacturation;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDatePaiement() {
		return datePaiement;
	}
	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}
	public List<BonCommande> getBonCommandes() {
		return bonCommandes;
	}
	public void setBonCommandes(List<BonCommande> bonCommandes) {
		this.bonCommandes = bonCommandes;
	}
	public Administrateur getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}
	
	
	
}
