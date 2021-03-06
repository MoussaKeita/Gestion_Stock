package com.stock.mvc.bean;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name="Fournisseur")
public class Fournisseur implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	private String nom;
	private String prenom;
	private String adresse;
	private String email;
	private String password;
	private String photo;
	private String raisonSociale;
	private Long tel;
	
    @OneToMany(mappedBy="fournisseur")
    private List<CommandeFournisseur> commandeFournisseurs;
	
	@OneToMany(mappedBy="fournisseur")
    private List<MouvementStock> mouvementStocks;
	
	
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
	public List<MouvementStock> getMouvementStocks() {
		return mouvementStocks;
	}
	public void setMouvementStocks(List<MouvementStock> mouvementStocks) {
		this.mouvementStocks = mouvementStocks;
	}
	@JsonIgnore
	public List<CommandeFournisseur> getCommandeFournisseurs() {
		return commandeFournisseurs;
	}
	public void setCommandeFournisseurs(List<CommandeFournisseur> commandeFournisseurs) {
		this.commandeFournisseurs = commandeFournisseurs;
	}
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public Long getTel() {
		return tel;
	}
	public void setTel(Long tel) {
		this.tel = tel;
	}
	
	
}