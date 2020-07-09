package com.jguiller.InfoClientService.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(controllers = ClientController.class)
public class ClientControllerTest {
	
	@Autowired
	private WebTestClient webClient;
	

}
