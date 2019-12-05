package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ProviderRepository;
import com.example.projetoIntegrado.database.ServiceRepository;
import com.example.projetoIntegrado.exeception.NotFoundException;
import com.example.projetoIntegrado.request.ServiceRequest;
import domain.Provider;
import domain.ServiceDomain;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class AskForProviderUsecase {

    private final ProviderRepository providerRepository;
    private final ServiceRepository serviceRepository;


    public ServiceDomain execute(ServiceRequest request) {

        Optional<Provider> provider = providerRepository.findByCpf(request.getId());
        if (provider.isEmpty())
            throw new NotFoundException("not_found");

        final ServiceDomain serviceDomain = new ServiceDomain();
        serviceDomain.setCpf(request.getId());
        serviceDomain.setCategory(request.getCategory());
        serviceDomain.setServiceDescription(request.getServiceDescription());
        serviceDomain.setServiceName(request.getServiceName());
        serviceDomain.setValue(request.getValue());
        serviceDomain.setProviderName(provider.get().getUserName());
        serviceRepository.save(serviceDomain);

        return serviceDomain;
    }
}
