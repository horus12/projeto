package com.example.projetoIntegrado.database;

import domain.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceMongoRepository extends MongoRepository<Service, String>, ServiceRepository {
}
