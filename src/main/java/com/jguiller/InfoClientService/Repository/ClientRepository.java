package com.jguiller.InfoClientService.Repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.jguiller.InfoClientService.Model.Client;

@Repository
public interface ClientRepository extends ReactiveMongoRepository<Client, Integer>{

}
