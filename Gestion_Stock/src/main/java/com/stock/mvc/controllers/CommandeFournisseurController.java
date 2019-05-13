package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String nouvelleCommande(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs==null) {
			fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs",fournisseurs);
		model.addAttribute("codeCmd", modelCommande.generateCodeCommande());
		model.addAttribute("dateCmd" , new Date());
		return "commandefournisseur/nouvelleCommande";
		
	}
}
