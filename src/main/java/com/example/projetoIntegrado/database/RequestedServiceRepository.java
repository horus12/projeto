package com.example.projetoIntegrado.database;

import domain.RequestedService;

public interface RequestedServiceRepository {
    RequestedService save(RequestedService requestedService);
}
