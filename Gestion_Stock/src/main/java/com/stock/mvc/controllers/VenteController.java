package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.Vente;
import com.stock.mvc.model.ModelVente;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.CommandeClientService;
//import com.stock.mvc.service.LigneVenteService;
import com.stock.mvc.service.VenteService;


@Controller
@RequestMapping(value="/vente")
public class VenteController {

	@Autowired
	private VenteService venteService;
	@Autowired
	private CommandeClientService cmdService;
	@Autowired
	private CommandeClientService commandeClientService;
	@Autowired
	private ArticleService articleService;
	/*@Autowired
	private LigneVenteService ligneVenteService;*/
	@Autowired
	private ModelVente modelVente;
	@Autowired
	private CommandeClientService commandeclientService;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		
		List<Vente> ventes = venteService.selectAll();
		List<CommandeClient> cmdClients = commandeclientService.selectAll();
		if(ventes.isEmpty()) {
			ventes = new ArrayList<Vente>();
		}
		model.addAttribute("ventes",ventes);
		model.addAttribute("cmdClients",cmdClients);
		
		return "vente/vente";
         }
	
	@RequestMapping(value="/nouveau")
	public String nouvelleCommande(Model model) {
		List<CommandeClient> cmdClients = commandeClientService.selectAll();
		if(cmdClients==null) {
			cmdClients = new ArrayList<CommandeClient>();
		}
		modelVente.creerVente();
		model.addAttribute("codecmd",modelVente.getCommande().getCode());
		model.addAttribute("dateCmd",modelVente.getCommande().getDateVente());
		model.addAttribute("cmdClients",cmdClients);
		return "vente/nouvelleVente";	
	}
	
	@RequestMapping(value="/creerVente")
	@ResponseBody
	public Vente creerVente(final String code) {
		if(code==null) {
			return null;
		}
		CommandeClient commandeClient = commandeClientService.getbyCode(code);
		modelVente.modifierVente(commandeClient);
		if(commandeClient==null) {
			return null;
		}
		return modelVente.getCommande();		
	}
	
	@RequestMapping(value="/enregistrerVente")
	@ResponseBody
	public String enregistrerVente(HttpServletRequest request) {
		Vente nouvelleCommande = null;
		nouvelleCommande = venteService.save(modelVente.getCommande());
		CommandeClient cmd=nouvelleCommande.getCommandeClient();
		//cmd.setVente(nouvelleCommande);
		cmdService.save(cmd);
	/*if(nouvelleCommande !=null) {
		Collection<LigneVente> ligneVentes = modelVente.getLignesVente(nouvelleCommande);
		if(ligneVentes  !=null && !ligneVentes.isEmpty()) {
			//ligneCmdFournisseurService.update();
			for(LigneVente ligneV :ligneVentes) {
				ligneVenteService.save(ligneV);	
			}
			modelVente.init();
		}
		
	}*/
		return "redirect:/vente/";
	}
	
/*
	@RequestMapping(value="/ajouterLigne")
	@ResponseBody
	public LigneVente getArticleByCode(final String code) {
		if(code==null) {
			return null;
		}
		Article article = articleService.findOne("code",""+code);
		if(article==null) {
			return null;
		}
		return modelVente.ajouterLigneVente(article);
	}
	@RequestMapping(value="/supprimerLigne")
	@ResponseBody
	public LigneVente supprimerLigneCmd(final String code) {
		if(code==null) {
			return null;
		}
		Article article = articleService.getbyCode(code);
		if(article==null) {
			return null;
		}
		return modelVente.supprimerLigneVente(article);
	}
	
	@RequestMapping(value="/supprimerLigne/{id}")
	@ResponseBody
	public String supprimer(Model model , Long id) {
		if(id==null) {
			return null;
		}
		LigneVente ligne= ligneVenteService.getbyId(id);
		Article article = ligne.getArticle();
		if(article==null) {
			return null;
		}
		// modelCommande.supprimerLigneCmd(article);
		articleService.remove(article.getCode());
		return "redirect:/vente/modifierVente";
	}
	
	@RequestMapping(value="/enregistrer")
	@ResponseBody
	public String enregistrerCommande(Model model, Vente vente) {

		if(vente == null) {
			return null;
		}
			venteService.save(vente);
		
	
	return "redirect:/vente/";
	}
	/*
	@RequestMapping(value = "/modifier/{code}")
	public String modifierCommande(Model model ,@PathVariable String code) {
		
		if(code == null) {
			return null;
		}	
		Vente vente = venteService.getbyCode(code);
		if(vente == null) {
			return null;
		}
		Vente cmd = modelVente.updateVente(vente);
		//Map<Long,LigneCommandeFournisseur> map = new HashMap<Long,LigneCommandeFournisseur>();
		
		List<LigneVente> lignes = ligneVenteService.getbyCodeCommande(code);
		if (lignes != null || !lignes.isEmpty() ){
			for (LigneVente ligne : lignes) {
				//map.put(ligne.getArticle().getIdArticle(), ligne);
				modelVente.setLigne(ligne.getArticle().getCode(), ligne);
			}
		}
		model.addAttribute("commande", cmd);	
		model.addAttribute("lignes", lignes);
		return "vente/modifierVente";
	}
	*/
	@RequestMapping(value = "/supprimer/{code}")
	public String supprimerCommande(Model model, @PathVariable String code) {
		if (code == null) {
			return null;
		}
		Vente vente = venteService.getbyCode(code);
		venteService.remove(code);
		return "redirect:/vente/";
	}

}