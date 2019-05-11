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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Commande_Client")
public class CommandeClient implements Serializable {
/*
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;*/
	
	@Id
	private String code;
	private String dateCommande;
	private String total;
	@ManyToOne
	private Client client;
	@OneToMany(mappedBy="commandeClient")
	private List<LigneCmdClient> ligneCommandeClients;
	    

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public  String getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(String dateCommande) {
		this.dateCommande = dateCommande;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<LigneCmdClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}
	public void setLigneCommandeClients(List<LigneCmdClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}
	
	
	
}

