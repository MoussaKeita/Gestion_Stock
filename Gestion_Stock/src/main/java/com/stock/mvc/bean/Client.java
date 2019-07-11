package com.stock.mvc.bean;
import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonManagedReference;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="Client")
public class Client implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String password;
	private String photo;
    @OneToMany(mappedBy = "client")
	private List<BonCommande> bonCommandes;
    
  /* @OneToMany(mappedBy="client",fetch = FetchType.EAGER , cascade= CascadeType.REMOVE)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonManagedReference*/
 
    @OneToMany(mappedBy="client")
    private List<CommandeClient> commandeClients;
  /*  
    @OneToMany(mappedBy = "client")
	private List<Vente> ventes;
    */
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
	@JsonIgnore
	public List<BonCommande> getBonCommandes() {
		return bonCommandes;
	}
	public void setBonCommandes(List<BonCommande> bonCommandes) {
		this.bonCommandes = bonCommandes;
	}
	@JsonIgnore
	public List<CommandeClient> getCommandeClients() {
		return commandeClients;
	}
	public void setCommandeClients(List<CommandeClient> commandeClients) {
		this.commandeClients = commandeClients;
	}/*
	public List<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}
*/
	
    
}
