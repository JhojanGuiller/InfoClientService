package com.jguiller.InfoClientService.Controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.jguiller.InfoClientService.Model.Client;
import com.jguiller.InfoClientService.Service.ClientService;

import reactor.core.publisher.Mono;

@WebFluxTest()
public class ClientControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;
	
	@MockBean
	private ClientService clientService;
	
	@Test
	public void getAllClientTest() {
		
		webTestClient
		.get()
		.uri("/clients")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBodyList(Client.class);
		
	}
	
	@Test
	public void getClientByIdTest() {
		
		Integer id = 1;
		
		Mockito
		.when(this.clientService.getClientById(id))
		.thenReturn(Mono.just(new Client(1, "Raul", "Santana Torres", "12345678", "Personal")));		
		
		this.webTestClient
		.get()
		.uri("/clients/{idCliente}", id)
		.exchange()
		.expectStatus().isOk()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectBody()
		.jsonPath("$..idCliente").isEqualTo(1)
		.jsonPath("$..nombre").isEqualTo("Raul")
		.jsonPath("$..apellido").isEqualTo("Santana Torres")
		.jsonPath("$..dni").isEqualTo("12345678")
		.jsonPath("$..tipoCliente").isEqualTo("Personal");
		
	}
	
	@Test
	public void addClientTest() {
		
		Client client = new Client(1, "Raul", "Santana Torres", "12345678", "Personal");
		
		webTestClient
		.post()
		.uri("/clients/addClient")
		.body(Mono.just(client), Client.class)
		.exchange()
		.expectStatus().isOk();
		
	}
	
	@Test
	public void updateClientTest() {
		
		Client client1 = new Client(1, "Raul", "Santana Torres", "12345678", "Personal");
		Client client2 = new Client(2, "Pedro", "Herrera Rodrigez", "87654321", "Empresarial");
		
		webTestClient
		.put()
		.uri("/clients/updateClient/{idCliente}", client1.getIdCliente())
		.body(Mono.just(client2), Client.class)
		.exchange()
		.expectStatus().isOk();
		
	}
	
	@Test
	public void deleteClientTest() {
		
		Integer id = 1;
		
		webTestClient
		.delete()
		.uri("/clients/deleteClient/{idCliente}", id)
		.exchange()
		.expectStatus().isOk();
		
	}
}
