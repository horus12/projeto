package com.example.projetoIntegrado.database;

import domain.RequestedService;

import java.util.List;


public interface RequestedServiceRepository {
    RequestedService save(RequestedService requestedService);
    List<RequestedService> findAllByProviderCpf(String providerCpf);
    List<RequestedService> findAllByUserCpf(String userCpf);

}
