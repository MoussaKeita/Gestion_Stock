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

import com.stock.mvc.bean.Client;
import com.stock.mvc.bean.Fournisseur;
import com.stock.mvc.service.FournisseurService;
import com.stock.mvc.service.IflickrService;

@Controller
@RequestMapping(value="/fournisseur")
public class FournisseurController {
	@Autowired
	private FournisseurService fournisseurService;
	@Autowired
	private IflickrService flickrService;
	
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
		model.addAttribute("fournisseur",fournisseur);
		return "fournisseur/ajouterFournisseur";
		
	}
	//@RequestMapping(value="/nouveau" , method = RequesetMethod.POST)
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Fournisseur fournisseur,MultipartFile file){
		String photoUrl =null;
		if(fournisseur!=null) {
			if(file!=null && !file.isEmpty()) {	
			InputStream stream=null;
			try{
			
				stream = file.getInputStream();
					photoUrl=flickrService.savePhoto(stream, fournisseur.getNom());
					fournisseur.setPhoto(photoUrl);
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
			if(fournisseur.getId()!=null){
				fournisseurService.update(fournisseur);
			         }
			else{
			
				fournisseurService.save(fournisseur);
			}
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