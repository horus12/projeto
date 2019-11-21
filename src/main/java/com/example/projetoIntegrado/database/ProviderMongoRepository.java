package com.example.projetoIntegrado.database;

import domain.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderMongoRepository extends MongoRepository<Provider, String>, ProviderRepository {
}
