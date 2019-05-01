package com.stock.mvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stock.mvc.bean.Client;
import com.stock.mvc.service.ClientService;

@Controller
@RequestMapping(value="/client")
public class ClientController {
	@Autowired
	private ClientService clientService;
	
	@RequestMapping("/")
	public String client(Model model) {
		List<Client> clients = clientService.selectAll();
		if(clients==null) {
			clients = new ArrayList<Client>();
		}
		model.addAttribute("clients",clients);
		return "client/client";
	}
	@RequestMapping(value="/nouveau" , method = RequestMethod.GET)
	public String ajouterClient(Model model) {
		return "client/ajouterClient";
		
	}
	@RequestMapping(value="/nouveau" , method = RequestMethod.POST)
	public String enregistrer(Model model) {
		return "redirect:/client/";
		
	}


}
