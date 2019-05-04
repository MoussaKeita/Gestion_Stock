package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.stock.mvc.bean.Category;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.stock.mvc.service.CategoryService;

@Controller
@RequestMapping(value="/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    
	@RequestMapping("/")
	public String category(Model model) {
		List<Category> categories = categoryService.selectAll();
		if(categories==null) {
			categories = new ArrayList<Category>();
		}
		model.addAttribute("categories",categories);
		return "category/category";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category",category);
		return "category/ajouterCategory";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Category category){
		if(category!=null) {
			if(category.getId()!=null){
				categoryService.update(category);
			         }
			else{
			
				categoryService.save(category);
			}
		}
		return "redirect:/category/";

		}
	//modification
	@RequestMapping(value="/modifier/{id}")
	public String modifierCategory(Model model, @PathVariable Long id) {
		if(id!=null) {
			Category category = categoryService.getbyId(id);
			if(category!=null) {
				model.addAttribute("category", category);
			}
		}
		
		return "category/ajouterCategory";
	}
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerCategory(Model model, @PathVariable Long id) {
		if(id!=null) {
			Category category = categoryService.getbyId(id);
			if(category!=null) {
				categoryService.remove(id);
			}
		}
		return "redirect:/category/";	
	}

}
