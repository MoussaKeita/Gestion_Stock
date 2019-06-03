package com.stock.mvc.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "vente")
public class Vente implements Serializable{
	// @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name="code_vente")
    private String code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    
    @OneToOne
	private CommandeClient commandeClient;
    
    @Transient
	private BigDecimal totalVente ;
    
    public Vente() {
   
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}
	public BigDecimal getTotalVente() {
		return totalVente;
	}

	public CommandeClient getCommandeClient() {
		return commandeClient;
	}

	public void setCommandeClient(CommandeClient commandeClient) {
		this.commandeClient = commandeClient;
	}

	public void setTotalVente(BigDecimal totalVente) {
		this.totalVente = totalVente;
	}	
    
}
