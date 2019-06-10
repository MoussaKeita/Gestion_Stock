package com.stock.mvc.controllers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;
import com.stock.mvc.export.FileExporter;
import com.stock.mvc.model.ModelCmdClient;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.ClientService;
import com.stock.mvc.service.CommandeClientService;
import com.stock.mvc.service.LigneCmdClientService;

@Controller
@RequestMapping(value="/commandeClient")
public class CommandeClientController {
	
	@Autowired
	private CommandeClientService commandeclientService;
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LigneCmdClientService ligneCmdClientService;
	@Autowired
	private ModelCmdClient modelCommande;
	@Autowired
	private ClientService clientService;
	
	@Autowired
	@Qualifier("bonExporter")
	private FileExporter exporter;
	/*
	@Autowired
	@Qualifier("detailsExporter")*/
	@RequestMapping("/")
	public String index(Model model) {
		
		List<CommandeClient> cmdClients = commandeclientService.selectAll();
		if(cmdClients.isEmpty()) {
			cmdClients = new ArrayList<CommandeClient>();
		}
		else {
			for(CommandeClient cmdClient : cmdClients) {
		  List<LigneCmdClient> ligneCmdClient = ligneCmdClientService.getbyCodeCommande(cmdClient.getCode());
		  cmdClient.setLigneCommandeClients(ligneCmdClient);
			}
		}
		model.addAttribute("cmdClients",cmdClients);
		
		return "commandeclient/commandeclient";
         }
	
	@RequestMapping(value="/nouveau")
	public String nouvelleCommande(Model model) {
		List<Client> clients = clientService.selectAll();
		if(clients==null) {
			clients = new ArrayList<Client>();
		}
		modelCommande.creerCommande();
		model.addAttribute("codecmd",modelCommande.getCommande().getCode());
		model.addAttribute("dateCmd",modelCommande.getCommande().getDateCommande());
		model.addAttribute("clients",clients);
		return "commandeclient/nouvelleCommande";	
	}
	
	@RequestMapping(value="/creerCommande")
	@ResponseBody
	
	public CommandeClient creerCommande(final Long id) {
		if(id==null) {
			return null;
		}
		Client client = clientService.getbyId(id);
		  modelCommande.modifierCommande(client);
		if(client==null) {
			return null;
		}
		return modelCommande.getCommande();		
	}
	@RequestMapping(value="/ajouterLigne")
	@ResponseBody
	public LigneCmdClient getArticleByCode(final String code) {
		if(code==null) {
			return null;
		}
		Article article = articleService.findOne("code",""+code);
		if(article==null) {
			return null;
		}
		return modelCommande.ajouterLigneCmd(article);
	}
	@RequestMapping(value="/supprimerLigne")
	@ResponseBody
	public LigneCmdClient supprimerLigneCmd(final String code) {
		if(code==null) {
			return null;
		}
		Article article = articleService.getbyCode(code);
		if(article==null) {
			return null;
		}
		return modelCommande.supprimerLigneCmd(article);
	}
	
	@RequestMapping(value="/supprimerLigne/{id}")
	@ResponseBody
	public String supprimer(Model model , Long id) {
		if(id==null) {
			return null;
		}
		LigneCmdClient ligne= ligneCmdClientService.getbyId(id);
		Article article = ligne.getArticle();
		if(article==null) {
			return null;
		}
		// modelCommande.supprimerLigneCmd(article);
		articleService.remove(article.getCode());
		return "redirect:/commandeClient/modifierCommande";
	}
	
	@RequestMapping(value="/enregistrerCommande")
	@ResponseBody
	public String enregistrerCommande(HttpServletRequest request) {
		CommandeClient nouvelleCommande = null;
		if(modelCommande.getCommande() !=null) {
			nouvelleCommande = commandeclientService.update(modelCommande.getCommande());
		}else {
			nouvelleCommande = commandeclientService.save(modelCommande.getCommande());
		}
		if(nouvelleCommande !=null) {
			Collection<LigneCmdClient> ligneCommandes = modelCommande.getLignesCmdClient(nouvelleCommande);
			if(ligneCommandes  !=null && !ligneCommandes .isEmpty()) {
				//ligneCmdFournisseurService.update();
				for(LigneCmdClient ligneCmdCli :ligneCommandes ) {
					ligneCmdClientService.save(ligneCmdCli);	
				}
				modelCommande.init();
			}
			
		}
		return "redirect:/commandeClient/";
	}
	@RequestMapping(value = "/modifier/{code}")
	public String modifierCommande(Model model ,@PathVariable String code) {
		
		if(code == null) {
			return null;
		}	
		CommandeClient commande = commandeclientService.getbyCode(code);
		if(commande == null) {
			return null;
		}
		CommandeClient cmd = modelCommande.updateCommande(commande);
		//Map<Long,LigneCommandeFournisseur> map = new HashMap<Long,LigneCommandeFournisseur>();
		
		List<LigneCmdClient> lignes = ligneCmdClientService.getbyCodeCommande(code);
		if (lignes != null || !lignes.isEmpty() ){
			for (LigneCmdClient ligne : lignes) {
				//map.put(ligne.getArticle().getIdArticle(), ligne);
				modelCommande.setLigne(ligne.getArticle().getCode(), ligne);
			}
		}
		model.addAttribute("commande", cmd);	
		model.addAttribute("lignes", lignes);
		return "commandeclient/modifierCommande";
	}
	
	@RequestMapping(value = "/supprimer/{code}")
	public String supprimerCommande(Model model, @PathVariable String code) {
		if (code == null) {
			return null;
		}
		CommandeClient commande = commandeclientService.getbyCode(code);
		List<LigneCmdClient> ligneCommandes = commande.getLigneCommandeClients();
		for(LigneCmdClient ligneCmdCli :ligneCommandes) {
			ligneCmdClientService.remove(ligneCmdCli.getId());
		}
		commandeclientService.remove(code);
		return "redirect:/commandeClient/";
	}
	
	@RequestMapping(value = "/modifierBon/{code}")
	public String modifierBon(Model model ,@PathVariable String code) {
			
		List<LigneCmdClient> lignes = ligneCmdClientService.getbyCodeCommande(code);
		if (lignes != null || !lignes.isEmpty() ){
			for (LigneCmdClient ligne : lignes) {
				//map.put(ligne.getArticle().getIdArticle(), ligne);
				modelCommande.setLigne(ligne.getArticle().getCode(), ligne);
			}
		}	
		model.addAttribute("lignes", lignes);
		return "commandeclient/blank";
	}
	

	@RequestMapping(value="/export/")
public String exportBon(HttpServletResponse response) {
	exporter.exportDataToExcel(response,null,null);
	return "commandeclient/commandeclient";
}

	@RequestMapping(value="/exportDetails/")
	public String exportDetails(HttpServletResponse response) {
		exporter.exportDataToExcel(response,null,null);
		return "commandeclient/commandeclient";
	}
}

