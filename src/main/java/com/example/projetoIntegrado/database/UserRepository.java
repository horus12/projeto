package com.example.projetoIntegrado.database;

import domain.User;

import java.util.Optional;

public interface UserRepository {

    User save(final User user);

    Optional<User> findByCpf(String cpf);

    Optional<User> findByUserName(String name);

}
