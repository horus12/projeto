package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ProviderRepository;
import com.example.projetoIntegrado.database.ServiceRepository;
import com.example.projetoIntegrado.exeception.NotFoundException;
import com.example.projetoIntegrado.request.CreateServiceRequest;
import domain.Provider;
import domain.Service;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class CreateServiceUsecase {

    private final ServiceRepository serviceRepository;
    private final ProviderRepository providerRepository;

    public Service execute(CreateServiceRequest createServiceRequest) {

        Optional<Provider> provider = providerRepository.findByCpf(createServiceRequest.getProviderCpf());
        if (!provider.isPresent()) throw new NotFoundException("provider_not_found");

        Service service = new Service();
        service.setCategory(createServiceRequest.getCategory());
        service.setProviderCpf(createServiceRequest.getProviderCpf());
        service.setProviderName(provider.get().getUserName());
        service.setServiceDescription(createServiceRequest.getServiceDescription());
        service.setServiceName(createServiceRequest.getServiceName());
        service.setValue(createServiceRequest.getValue());
        return serviceRepository.save(service);

    }

}
