package com.stock.mvc.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vente")
public class Vente implements Serializable{
    @Id
    @GeneratedValue
    @Column(name="id_vente")
    private Long id;
    private String code;
    private Date dateVente;
    @OneToMany(mappedBy="vente")
    private List<LigneVente> Ligneventes; 
    //@ManyToOne
    //private Administrateur administrateur;
    
    public Vente() {
    	
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<LigneVente> getLigneventes() {
		return Ligneventes;
	}

	public void setLigneventes(List<LigneVente> ligneventes) {
		Ligneventes = ligneventes;
	}
	
    
}
