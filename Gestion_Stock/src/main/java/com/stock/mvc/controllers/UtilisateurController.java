package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Category;
import com.stock.mvc.bean.Roles;
import com.stock.mvc.bean.Utilisateur;
import com.stock.mvc.service.RoleService;
import com.stock.mvc.service.UtilisateurService;

@Controller
@RequestMapping(value="/utilisateur")
public class UtilisateurController {
	@Autowired
    private UtilisateurService  userService;
	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/")
	public String users(Model model) {

		List<Utilisateur> users = userService.selectAll();

		if (users == null) {
			users = new ArrayList<Utilisateur>();
		}
		model.addAttribute("users", users);
		return "utilisateur/utilisateur";
	}

	@RequestMapping(value = "/nouveau", method = RequestMethod.GET)
	public String ajouterUtilisateur(Model model) {
 
		Utilisateur user = new Utilisateur();
 		model.addAttribute("user", user);
		return "utilisateur/ajouterUtilisateur";
	}

	@RequestMapping(value = "/enregistrer")
	public String enregistrer(Model model, Utilisateur user) {
	  	
		if (user != null) {
			
			if (user.getIdUtilisateur() != null) {
				userService.update(user);
			}else {
				
				userService.save(user);
			}
		}
		return "redirect:/utilisateur/";
	}
	@RequestMapping(value="/modifier/{idUtilisateur}")
	public String modifierUtilisateur(Model model,@PathVariable Long idUtilisateur) {
		if (idUtilisateur != null) {
			
			Utilisateur user = userService.getbyId(idUtilisateur);
			if (user != null) {
				model.addAttribute("user", user);
			}
		}
		
		return"utilisateurs/ajouterUtilisateur";
	}
	
	@RequestMapping(value="/supprimer/{idUtilisateur}")
	public String supprimerUtilisateur(Model model,@PathVariable Long idUtilisateur) {
		if (idUtilisateur != null) {
			
			Utilisateur user = userService.getbyId(idUtilisateur);
			if (user != null) {
				userService.remove(idUtilisateur);
			}
		}
		
		return"redirect:/utilisateur/";
	}
	
}
