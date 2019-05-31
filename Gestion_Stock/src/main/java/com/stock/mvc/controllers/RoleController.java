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
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.RoleService;
import com.stock.mvc.service.UtilisateurService;

@Controller
@RequestMapping(value="/role")
public class RoleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UtilisateurService  userService;
	@Autowired
	private RoleService roleService;

	// find//
	@RequestMapping("/")
	public String Role(Model model) {
		List<Roles> roles = roleService.selectAll();
		if(roles ==null) {
			roles  = new ArrayList<Roles>();
		}
		model.addAttribute("roles",roles);
		return "role/role";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterRole(Model model) {
		Roles role = new Roles();
		List<Utilisateur> users = userService.selectAll();
		if(users==null) {
			users = new ArrayList<Utilisateur>();
		}
		model.addAttribute("role",role);
		model.addAttribute("users",users);
		return "role/ajouterRole";
		
	}
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Roles role){
		if(role!=null) {
			if(role.getIdRole()!=null){
				roleService.update(role);
			         }
			else{
			
				roleService.save(role);
			}
		}
		return "redirect:/role/";

		}
	
/*
	//modification
	@RequestMapping(value="/modifier/{idRole}")
	public String modifierArticle(Model model, @PathVariable String idRole) {
		if(idRole!=null) {
			Roles role = roleService.getbyId(idRole);
			List<Utilisateur> utilisateurs = userService.selectAll();
			if(categories==null) {
				 categories = new ArrayList<Category>();
			}
			model.addAttribute("categories",categories);
			if(article!=null) {
				model.addAttribute("article", article);
			}
		}
		
		return "article/ajouterArticle";
	}
	@RequestMapping(value="/supprimer/{idRole}")
	public String supprimerRole(Model model, @PathVariable String idRole) {
		if(idRole!=null) {
			Roles role = roleService.getbyId(idRole);
			if(role!=null) {
				articleService.remove(idRole);
			}
		}
		return "redirect:/article/";	
	}*/
}
