package com.stock.mvc.controllers;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.bean.CommandeClient;
import com.stock.mvc.bean.LigneCmdClient;
import com.stock.mvc.service.CommandeClientService;
import com.stock.mvc.service.LigneCmdClientService;

@Controller
@RequestMapping(value="/commandeClient")
public class CommandeClientController {
	@Autowired
	private CommandeClientService clientService;
	
	// find//
	@RequestMapping("/")
	public String index(Model model) {
		List<CommandeClient> clients = clientService.selectAll();
		if(clients.isEmpty()) {
			clients = new ArrayList<CommandeClient>();
		}
		/*else {
			for(CommandeClient commandeClient: clients) {
			List<LigneCmdClient> ligneCdeClt= ligneCommandeClientService.
			}
		}*/
		model.addAttribute("clients",clients);
		return "commandeclient/commandeclient";
	}

	//find par defaut//
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		CommandeClient client = new CommandeClient();
		model.addAttribute("client",client);
		return "commandeclient/ajouterCommande";
		
	}
	
	//creation et mis a jours//
	@RequestMapping(value="/enregistrer")
	public String enregistrer(Model model, CommandeClient client){
		
			if(client.getCode()!=null){
			              clientService.update(client);
			         }
			else{
			
			clientService.save(client);
			}
			return "redirect:/commandeClient/";
		}
		
	//modification
	@RequestMapping(value="/modifier/{code}")
	public String modifierClient(Model model, @PathVariable String code) {
		if(code!=null) {
			CommandeClient client = clientService.getbyCode(code);
			if(client!=null) {
				model.addAttribute("client", client);
			}
		}
		
		return "commandeclient/ajouterCommande";
	}
	@RequestMapping(value="/supprimer/{code}")
	public String supprimerClient(Model model, @PathVariable String code) {
		if(code!=null) {
			CommandeClient client= clientService.getbyCode(code);
			if(client!=null) {
				clientService.removebyCode(code);
			}
		}
		return "redirect:/commandeClient/";	
	}
	
}

