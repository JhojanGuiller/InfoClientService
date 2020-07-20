package com.jguiller.InfoClientService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jguiller.InfoClientService.Model.Client;
import com.jguiller.InfoClientService.Repository.ClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	// OBTENER TODOS LOS CLIENTES
	public Flux<Client> getAllClients() {
		return clientRepository.findAll();
	}
	
	// AGREGAR UN CLIENTE
	public Mono<Client> addClient(Client client) {
		return clientRepository.save(client);
	}
	
	// OBTENER UN CLIENTE POR SU ID
	public Mono<Client> getClientById(Integer id) {
		return clientRepository.findById(id);
	}
	
	// EDITAR UN CLIENTE POR SU ID
	public Mono<Client> updateClient(Client client, Integer id) {
		return clientRepository.findById(id).flatMap(cli -> {
			cli.setNombre(client.getNombre());
			cli.setApellido(client.getApellido());
			cli.setDni(client.getDni());
			cli.setTipoCliente(client.getTipoCliente());
			return clientRepository.save(cli);
		});
	}

	// ELIMINAR UN CLIENTE POR SU ID
	public Mono<Void> deleteClient(Integer id) {
		return clientRepository.deleteById(id);
	}
	
}
