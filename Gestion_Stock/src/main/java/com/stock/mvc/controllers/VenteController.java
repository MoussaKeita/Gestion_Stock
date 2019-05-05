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

import com.stock.mvc.bean.Vente;
import com.stock.mvc.service.VenteService;
import com.stock.mvc.service.IflickrService;

@Controller
@RequestMapping(value="/vente")
public class VenteController {
	@Autowired
	private VenteService venteService;
	@Autowired
	private IflickrService flickrService;
	// find//
	@RequestMapping("/")
	public String vente(Model model) {
		List<Vente> ventes = venteService.selectAll();
		if(ventes==null) {
			ventes = new ArrayList<Vente>();
		}
		model.addAttribute("ventes",ventes);
		return "vente/vente";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterVente(Model model) {
		Vente vente = new Vente();
		model.addAttribute("vente",vente);
		return "vente/ajouterVente";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
    public String enregistrer(Model model, Vente vente){
		
			if(vente.getCode()!=null){
			              venteService.update(vente);
			         }
			else{
			
			venteService.save(vente);
			}
		
		return "redirect:/vente/";

		}
	//modification
	@RequestMapping(value="/modifier/{code}")
	public String modifierVente(Model model, @PathVariable String code) {
		if(code!=null) {
			Vente vente = venteService.getbyCode(code);
			if(vente!=null) {
				model.addAttribute("vente",vente);
			}
		}
		
		return "vente/ajouterVente";
	}
	@RequestMapping(value="/supprimer/{code}")
	public String supprimerVente(Model model, @PathVariable String code) {
		if(code!=null) {
			Vente vente = venteService.getbyCode(code);
			if(vente!=null) {
				venteService.removebyCode(code);
			}
		}
		return "redirect:/vente/";	
	}

}
