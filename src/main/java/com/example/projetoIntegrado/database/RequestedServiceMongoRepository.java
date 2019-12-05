package com.example.projetoIntegrado.database;

import domain.RequestedService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestedServiceMongoRepository extends MongoRepository<RequestedService, String> ,RequestedServiceRepository {
}
