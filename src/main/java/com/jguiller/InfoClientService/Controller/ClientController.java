package com.jguiller.InfoClientService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
		return "Client add successfully: " + cli.getIdCliente();
	}
	
	@GetMapping("/findAllClients")
	public List<Client> getClients(){
		return cliRepository.findAll();
	}
	
	@GetMapping("/findClient/{idCliente}")
	public Optional<Client> getClient(@PathVariable int idCliente){
		return cliRepository.findByIdCliente(idCliente);
	}
	
	@GetMapping("/client")
	public Client obtenerClientePorDni(@RequestParam (value = "dni") String dni){
		return cliRepository.findByDni(dni);
	}
	
	@GetMapping("/deleteClient/{idCliente}")
	public String deleteClient(@PathVariable int idCliente) {
		cliRepository.deleteByIdCliente(idCliente);
		return "Deleted Client Successfully: " + idCliente;
	}
}
