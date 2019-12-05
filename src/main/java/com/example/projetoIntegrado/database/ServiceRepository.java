package com.example.projetoIntegrado.database;

import domain.ServiceDomain;

import java.util.List;

public interface ServiceRepository {
    ServiceDomain save(ServiceDomain serviceDomain);
    List<ServiceDomain> findAll();
}
