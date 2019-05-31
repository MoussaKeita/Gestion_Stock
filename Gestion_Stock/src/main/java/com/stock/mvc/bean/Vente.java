package com.stock.mvc.bean;


import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "vente")
public class Vente implements Serializable{
    @Id
    //@GeneratedValue
    @Column(name="code_vente")
    private String code;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateVente;
    
    @ManyToOne
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
