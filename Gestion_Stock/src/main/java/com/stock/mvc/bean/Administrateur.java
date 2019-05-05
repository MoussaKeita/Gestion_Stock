package com.stock.mvc.bean;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Administrateur")
public class Administrateur implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String password;
	private String photo;
	//@OneToMany(mappedBy="administrateur")
	//private List<Vente> ventes;
	
	@OneToMany(mappedBy="administrateur")
    private List<Facture> factures; 
	@OneToMany(mappedBy="administrateur")
    private List<LigneCmdClient> ligneCmdClients; 

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	public List<LigneCmdClient> getLigneCmdClients() {
		return ligneCmdClients;
	}
	public void setLigneCmdClients(List<LigneCmdClient> ligneCmdClients) {
		this.ligneCmdClients = ligneCmdClients;
	}
	
	
	
	
}

