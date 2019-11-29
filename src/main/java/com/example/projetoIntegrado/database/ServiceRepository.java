package com.example.projetoIntegrado.database;

import domain.ServiceDomain;

public interface ServiceRepository {
    ServiceDomain save(ServiceDomain serviceDomain);
}
