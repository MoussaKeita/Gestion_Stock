package com.stock.mvc.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.service.FournisseurService;

@Controller
@RequestMapping(value="/fournisseur")
public class FournisseurController {
	@Autowired
	private FournisseurService fournisseurService;
	
	@RequestMapping("/")
	public String fournisseur(Model model) {
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(fournisseurs==null) {
		fournisseurs = new ArrayList<Fournisseur>();
		}
		model.addAttribute("fournisseurs",fournisseurs);
		return "fournisseur/fournisseur";
	}
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterFournisseur(Model model) {
		Fournisseur fournisseur = new Fournisseur();
		model.addAttribute("fournisseur","fournisseur");
		return "fournisseur/ajouterFournisseur";
		
	}
	//@RequestMapping(value="/nouveau" , method = RequesetMethod.POST)
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Fournisseur fournisseur) {
		if(fournisseur.getId()!=null) {
			
			fournisseurService.update(fournisseur);
		}else {
			fournisseurService.save(fournisseur);
		}
		return "redirect:/fournisseur/";	
	}
	@RequestMapping(value="/modifier/{id}")
	public String modifierFournisseur(Model model, @PathVariable Long id) {
		if(id!=null) {
			Fournisseur fournisseur = fournisseurService.getbyId(id);
			if(fournisseur!=null) {
				model.addAttribute("fournisseur",fournisseur);
			}
		}
		
		return "fournisseur/ajouterFournisseur";
	}
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerFournisseur(Model model, @PathVariable Long id) {
		if(id!=null) {
			Fournisseur fournisseur = fournisseurService.getbyId(id);
			if(fournisseur!=null) {
				fournisseurService.remove(id);
			}
		}
		return "redirect:/fournisseur/";	
	}


}