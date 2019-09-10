package com.example.projetoIntegrado.database;

import domain.User;
import domain.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMongoRepository extends MongoRepository<User, String>, UserRepository {
}
