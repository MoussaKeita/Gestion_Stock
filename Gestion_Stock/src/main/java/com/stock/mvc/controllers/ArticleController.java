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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.stock.mvc.bean.Article;
import com.stock.mvc.bean.Category;
import com.stock.mvc.bean.MouvementStock;
import com.stock.mvc.service.ArticleService;
import com.stock.mvc.service.CategoryService;
import com.stock.mvc.service.IflickrService;
import com.stock.mvc.service.MouvementStockService;

@Controller
@RequestMapping(value="/article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private MouvementStockService stockService;
	@Autowired
	private IflickrService flickrService;
	/*
	@Autowired
	@Qualifier("articleExporter")
	private FileExporter exporter;*/
	// find//
	@RequestMapping("/")
	public String article(Model model) {
		List<Article> articles = articleService.selectAll();
		if(articles ==null) {
			articles  = new ArrayList<Article>();
		}
		model.addAttribute("articles",articles);
		return "article/article";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterArticle(Model model) {
		Article article = new Article();
		List<Category> categories = categoryService.selectAll();
		if(categories==null) {
			 categories = new ArrayList<Category>();
		}
		model.addAttribute("article",article);
		model.addAttribute("categories",categories);
		return "article/ajouterArticle";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Article article,MultipartFile file){
		String photoUrl =null;
		if(article!=null) {
			if(file!=null && !file.isEmpty()) {	
			InputStream stream=null;
			try{
			
				stream = file.getInputStream();
					photoUrl=flickrService.savePhoto(stream, article.getLibelle());
					article.setPhoto(photoUrl);
			  }	catch(Exception e){
			               e.printStackTrace();
			        }	finally {
			        	try {
							stream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
			      
			        }
						
			}
			if(article.getCode()!=null){
				articleService.update(article);
			         }
			else{
			
				articleService.save(article);
			}
		}
		return "redirect:/article/";

		}
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
			List<MouvementStock> stocks = article.getMouvementStocks();
			for(MouvementStock stock :stocks) {
				stockService.remove(stock.getId());
		}	
				articleService.remove(code);
		}
		return "redirect:/article/";	
	}/*
	@RequestMapping(value="/export/")
	//@RequestMapping("/pdf/{fileName:.+}")
public String exportArticles(HttpServletResponse response) {
	exporter.exportDataToExcel(response,null,null);
	return "article/article";
}*/


}
