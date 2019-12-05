package com.example.projetoIntegrado.database;

import domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    Service save(Service service);
    Optional<Service> findByProviderCpfAndServiceName(String providerCpf, String serviceName);
    List<Service> findAll();
}
