package com.example.projetoIntegrado.database;

import domain.Provider;
import domain.ServiceDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ServiceMongoRepository extends MongoRepository<ServiceDomain, String>, ServiceRepository {
}
