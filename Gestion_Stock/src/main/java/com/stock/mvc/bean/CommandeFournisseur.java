package com.stock.mvc.bean;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

@Entity
@Table(name="Commande_Fournisseur")
public class CommandeFournisseur implements Serializable {

	@Id
    @Column(name="code_CmdFournisseur")
    private String code;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCommande;
	@Transient
	private BigDecimal totalCommande;
	
	public void setTotalCommande(BigDecimal totalCommande) {
		this.totalCommande = totalCommande;
	}
	@ManyToOne
	private Fournisseur fournisseur; 
	
	@OneToMany(mappedBy ="commandeFournisseur",fetch = FetchType.EAGER , cascade= CascadeType.REMOVE)
	private List<LigneCmdFournisseur> ligneCmdFournisseurs;

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
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	@JsonIgnore
	public List<LigneCmdFournisseur> getLigneCmdFournisseurs() {
		return ligneCmdFournisseurs;
	}
	public void setLigneCmdFournisseurs(List<LigneCmdFournisseur> ligneCmdFournisseurs) {
		this.ligneCmdFournisseurs = ligneCmdFournisseurs;
	}
	public BigDecimal getTotalCommande() {
		totalCommande = BigDecimal.ZERO;
		if(!ligneCmdFournisseurs.isEmpty()) {
			for(LigneCmdFournisseur ligneCmdFournisseur :ligneCmdFournisseurs ) {
				if(ligneCmdFournisseur.getQuantite()!=null && ligneCmdFournisseur.getPrixUnitaireTTC()!=null) {
			BigDecimal totalLigne = ligneCmdFournisseur.getQuantite().multiply(ligneCmdFournisseur.getPrixUnitaireTTC());
			totalCommande = totalCommande.add(totalLigne);
				}
			}
		}
		return totalCommande;
	}
	@Transient
	public String getLigneCommandeJson() {
		if(!ligneCmdFournisseurs.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(ligneCmdFournisseurs);
				
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			}catch(JsonMappingException e) {
				e.printStackTrace();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}
	

}