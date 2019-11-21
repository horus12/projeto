package com.example.projetoIntegrado.database;

import domain.Provider;

import java.util.Optional;

public interface ProviderRepository {

    Provider save(final Provider user);

    Optional<Provider> findByCpf(String cpf);

    Optional<Provider> findByUserName(String name);

}
