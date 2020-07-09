package com.jguiller.InfoClientService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jguiller.InfoClientService.Model.Client;
import com.jguiller.InfoClientService.Repository.ClientRepository;

@RestController
public class ClientController {

	@Autowired
	private ClientRepository cliRepository;
	
	@PostMapping("/addClient")
	public String saveClient(@RequestBody Client cli) {
		cliRepository.save(cli);
		return "Client add successfully: " + cli.getId();
	}
	
	@GetMapping("/findAllClients")
	public List<Client> getClients(){
		return cliRepository.findAll();
	}
	
	@GetMapping("/findClient/{id}")
	public Optional<Client> getClient(@PathVariable int id){
		return cliRepository.findById(id);
	}
	
	@GetMapping("deleteClient/{id}")
	public String deleteClient(@PathVariable int id) {
		cliRepository.deleteById(id);
		return "Deleted Client Successfully: " + id;
	}
}
