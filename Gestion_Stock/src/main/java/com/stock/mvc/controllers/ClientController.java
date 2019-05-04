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
import com.stock.mvc.service.ClientService;
import com.stock.mvc.service.IflickrService;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	@Autowired
	private IflickrService flickrService;
	// find//
	@RequestMapping("/")
	public String client(Model model) {
		List<Client> clients = clientService.selectAll();
		if(clients==null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		return "client/client";
	}
	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		Client client = new Client();
		model.addAttribute("client",client);
		return "client/ajouterClient";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, Client client,MultipartFile file){
		String photoUrl =null;
		if(client!=null) {
			if(file!=null && !file.isEmpty()) {	
			InputStream stream=null;
			try{
			
				stream = file.getInputStream();
					photoUrl=flickrService.savePhoto(stream, client.getNom());
					client.setPhoto(photoUrl);
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
			if(client.getId()!=null){
			              clientService.update(client);
			         }
			else{
			
			clientService.save(client);
			}
		}
		return "redirect:/client/";

		}
	//modification
	@RequestMapping(value="/modifier/{id}")
	public String modifierClient(Model model, @PathVariable Long id) {
		if(id!=null) {
			Client client = clientService.getbyId(id);
			if(client!=null) {
				model.addAttribute("client", client);
			}
		}
		
		return "client/ajouterClient";
	}
	@RequestMapping(value="/supprimer/{id}")
	public String supprimerClient(Model model, @PathVariable Long id) {
		if(id!=null) {
			Client client = clientService.getbyId(id);
			if(client!=null) {
				clientService.remove(id);
			}
		}
		return "redirect:/client/";	
	}

}
