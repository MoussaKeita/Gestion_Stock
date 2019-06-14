package com.stock.mvc.bean;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

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
	@Transient
	private BigDecimal totalCommande;
	
	@ManyToOne
	private Client client;
	/*
	@LazyCollection(LazyCollectionOption.FALSE)
	@Fetch(value = FetchMode.SUBSELECT)
	@JsonBackReference*/
	@OneToMany(mappedBy="commandeClient",fetch = FetchType.EAGER , cascade= CascadeType.REMOVE)
	private List<LigneCmdClient> ligneCommandeClients;
	
	@JsonIgnore
	public List<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}
	@OneToMany(mappedBy="commandeClient")
    private List<Vente> ventes; 

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
	public void setTotalCommande(BigDecimal totalCommande) {
		this.totalCommande = totalCommande;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	@JsonIgnore
	public List<LigneCmdClient> getLigneCommandeClients() {
		return ligneCommandeClients;
	}
	public void setLigneCommandeClients(List<LigneCmdClient> ligneCommandeClients) {
		this.ligneCommandeClients = ligneCommandeClients;
	}

	
	public BigDecimal getTotalCommande() {
		totalCommande = BigDecimal.ZERO;
		if(!ligneCommandeClients.isEmpty()) {
			for(LigneCmdClient ligneCommandeClient :ligneCommandeClients) {
				if(ligneCommandeClient.getQuantite()!=null && ligneCommandeClient.getPrixUnitaireTTC()!=null) {
			BigDecimal totalLigne = ligneCommandeClient.getQuantite().multiply(ligneCommandeClient.getPrixUnitaireTTC());
			totalCommande = totalCommande.add(totalLigne);
				}
			}
		}
		return totalCommande;
	}
	@Transient
	public String getLigneCommandeJson() {
		if(!ligneCommandeClients.isEmpty()) {
			try {
				ObjectMapper mapper = new ObjectMapper();
				return mapper.writeValueAsString(ligneCommandeClients);
				
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

