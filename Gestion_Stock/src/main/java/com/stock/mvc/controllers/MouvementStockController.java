package com.stock.mvc.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Category;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.bean.MouvementStock;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.FournisseurService;
import com.stock.mvc.service.MouvementStockService;

@Controller
@RequestMapping(value="/stock")
public class MouvementStockController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private MouvementStockService stockService;
	@Autowired
	private FournisseurService fournisseurService;
	
	// find//
	@RequestMapping("/")
	public String Stock(Model model) {
		List<MouvementStock> stocks = stockService.selectAll();
		if(stocks ==null) {
			stocks  = new ArrayList<MouvementStock>();
		}
		model.addAttribute("stocks",stocks);
		return "mouvementStock/mouvementStock";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" )
	public String ajouterStock(Model model) {
		MouvementStock stock = new MouvementStock();
		List<Article> articles = articleService.selectAll();
		List<Fournisseur> fournisseurs = fournisseurService.selectAll();
		if(articles==null || fournisseurs==null) {
			articles = new ArrayList<Article>();
			fournisseurs= new ArrayList<Fournisseur>();
		}
		model.addAttribute("stock",stock);
		model.addAttribute("articles",articles);
		model.addAttribute("fournisseurs",fournisseurs);
		return "mouvementStock/AjouterMouvementStock";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, MouvementStock stock){
		
			if(stock.getId()!=null){
				stockService.update(stock);
			         }
			else{
			
				stockService.save(stock);
			}
		
		return "redirect:/stock/";

		}/*
	//modification
	@RequestMapping(value="/modifier/{code}")
	public String modifierArticle(Model model, @PathVariable String code) {
		if(code!=null) {
			Article article = articleService.getbyCode(code);
			List<Category> categories = categoryService.selectAll();
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
	@RequestMapping(value="/supprimer/{code}")
	public String supprimerArticle(Model model, @PathVariable String code) {
		if(code!=null) {
			Article article = articleService.getbyCode(code);
			if(article!=null) {
				articleService.remove(code);
			}
		}
		return "redirect:/article/";	
	}
	
	@RequestMapping(value="/export/")
public String exportArticles(HttpServletResponse response) {
	exporter.exportDataToExcel(response,null,null);
	return "article/article";
}
*/
}
