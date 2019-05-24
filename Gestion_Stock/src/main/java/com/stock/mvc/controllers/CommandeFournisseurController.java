package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.CommandeFournisseur;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.bean.LigneCmdFournisseur;
import com.stock.mvc.model.ModelCmdFournisseur;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.CommandeFournisseurService;
import com.stock.mvc.service.FournisseurService;
import com.stock.mvc.service.LigneCmdFournisseurService;

@Controller
@RequestMapping(value="/commandefournisseur")
public class CommandeFournisseurController {

	@Autowired
	private CommandeFournisseurService cmdFournisseurService;
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private ArticleService articleService;
	@Autowired
	private LigneCmdFournisseurService ligneCmdFournisseurService;
	@Autowired
	private ModelCmdFournisseur modelCommande;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		List<CommandeFournisseur> cmdfournisseurs = cmdFournisseurService.selectAll();
		if(cmdfournisseurs.isEmpty()) {
			cmdfournisseurs = new ArrayList<CommandeFournisseur>();
		}
		else {
			for(CommandeFournisseur cmdFournisseur : cmdfournisseurs) {
		  List<LigneCmdFournisseur> ligneCmdFournisseur = ligneCmdFournisseurService.getbyCodeCommande(cmdFournisseur.getCode());
		  cmdFournisseur.setLigneCmdFournisseurs(ligneCmdFournisseur);
			}
		}
		model.addAttribute("cmdfournisseurs",cmdfournisseurs);
		
		return "commandefournisseur/commandefournisseur";
         }
	
	@RequestMapping(value="/nouveau")
	public String nouvelleCommande(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs==null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		modelCommande.creerCommande();
		model.addAttribute("codecmd",modelCommande.getCommande().getCode());
		model.addAttribute("dateCmd",modelCommande.getCommande().getDateCommande());
		model.addAttribute("fournisseurs",fournisseurs);
		return "commandefournisseur/nouvelleCommande";	
	}
	
	@RequestMapping(value="/creerCommande")
	@ResponseBody
	
	public CommandeFournisseur creerCommande(final Long id) {
		if(id==null) {
			return null;
		}
		Fournisseur fournisseur = fournisseurService.getbyId(id);
		  modelCommande.modifierCommande(fournisseur);
		if(fournisseur==null) {
			return null;
		}
		return modelCommande.getCommande();		
	}
	@RequestMapping(value="/ajouterLigne")
	@ResponseBody
	public LigneCmdFournisseur getArticleByCode(final String code) {
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
	public LigneCmdFournisseur supprimerLigneCmd(final String code) {
		if(code==null) {
			return null;
		}
		Article article = articleService.getbyCode(code);
		if(article==null) {
			return null;
		}
		return modelCommande.supprimerLigneCmd(article);
	}
	@RequestMapping(value="/enregistrerCommande")
	@ResponseBody
	public String enregistrerCommande(HttpServletRequest request) {
		CommandeFournisseur nouvelleCommande = null;
		//if(modelCommande.getCommande() !=null) {
			nouvelleCommande = cmdFournisseurService.save(modelCommande.getCommande());
		//}
		if(nouvelleCommande !=null) {
			Collection<LigneCmdFournisseur> ligneCommandes = modelCommande.getLignesCmdFournisseur(nouvelleCommande);
			if(ligneCommandes  !=null && !ligneCommandes .isEmpty()) {
				for(LigneCmdFournisseur ligneCmdFourni :ligneCommandes ) {
					ligneCmdFournisseurService.save(ligneCmdFourni);	
				}
				modelCommande.init();
			}
			
		}
		return "redirect:/commandefournisseur/";
	}
	@RequestMapping(value = "/supprimer/{code}")
	public String supprimerFournisseur(Model model, @PathVariable String code) {
		if (code == null) {
			return null;
		}
		CommandeFournisseur commande = cmdFournisseurService.getbyCode(code);
		List<LigneCmdFournisseur> ligneCommandes = commande.getLigneCmdFournisseurs();
		for(LigneCmdFournisseur ligneCmdFourni :ligneCommandes) {
			ligneCmdFournisseurService.remove(ligneCmdFourni.getId());
		}
		cmdFournisseurService.remove(code);
		return "redirect:/commandefournisseur/";
	}

}
