package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ServiceRepository;
import domain.ServiceDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AskForProviderUsecase {

    ServiceRepository serviceRepository;

    @Autowired
    public AskForProviderUsecase(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceDomain execute(ServiceDomain serviceDomain) {
        return serviceRepository.save(serviceDomain);
    }
}
