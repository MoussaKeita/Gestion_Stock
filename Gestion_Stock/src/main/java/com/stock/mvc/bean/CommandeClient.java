package com.stock.mvc.bean;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
}

