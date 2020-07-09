package com.jguiller.InfoClientService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.jguiller.InfoClientService.Model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Integer>{

}
