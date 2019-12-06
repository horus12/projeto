package com.example.projetoIntegrado.database;

import domain.RequestedService;

import java.util.List;

public interface RequestedServiceRepository {
    RequestedService save(RequestedService requestedService);
    List<RequestedService> findAllByCpf(String providerCpf);

}
