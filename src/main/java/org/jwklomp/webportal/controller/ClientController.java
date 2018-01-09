package org.jwklomp.webportal.controller;

import java.util.List;

import org.jwklomp.webportal.domain.Client;
import org.jwklomp.webportal.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@RequestMapping("/clients")
	@CrossOrigin(origins = "http://localhost:8080")
	public List<Client> clients() {
		return clientRepository.findAll();
	}
	
	@RequestMapping("/client")
	@CrossOrigin(origins = "http://localhost:8080")
	public Client client(@RequestParam(value = "id") String clientId) {
		Client client = null;

		if (clientId != null && !clientId.isEmpty()) {
			client = clientRepository.getOneByClientId(clientId);
		}

		return client;
	}

}
