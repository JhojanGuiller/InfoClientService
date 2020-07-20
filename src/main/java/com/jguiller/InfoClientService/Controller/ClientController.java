package com.jguiller.InfoClientService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jguiller.InfoClientService.Model.Client;
import com.jguiller.InfoClientService.Service.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	// OBTENER TODOS LOS CLIENTES
	@GetMapping
	public Flux<Client> getClients(){
		return clientService.getAllClients();
	}
	
	// AGREGAR UN CLIENTE
	@PostMapping("/addClient")
	public Mono<Client> saveClient(@RequestBody Client client) {
		return clientService.addClient(client);
	}

	// OBTENER UN CLIENTE POR SU ID
	@GetMapping("/{idCliente}")
	public Mono<Client> getClienteById(@PathVariable(value = "idCliente") int id) {
		return clientService.getClientById(id);
	}

	// EDITAR UN CLIENTE POR SU ID
	@PutMapping("/updateClient/{idCliente}")
	public Mono<Client> updateCliente(@RequestBody Client client, @PathVariable (value = "idCliente") int id){
		return clientService.updateClient(client, id);
	}
	
	// ELIMINAR UN CLIENTE POR SU ID
	@DeleteMapping("/deleteClient/{idCliente}")
	public Mono<Void> deleteCliente(@PathVariable(value = "idCliente") int id) {
		return clientService.deleteClient(id);
	}
}
