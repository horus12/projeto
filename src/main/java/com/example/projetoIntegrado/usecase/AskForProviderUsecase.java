package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ProviderRepository;
import com.example.projetoIntegrado.database.RequestedServiceRepository;
import com.example.projetoIntegrado.database.ServiceRepository;
import com.example.projetoIntegrado.exeception.NotFoundException;
import com.example.projetoIntegrado.request.ServiceRequest;
import domain.Provider;
import domain.RequestedService;
import domain.Service;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
@Data
public class AskForProviderUsecase {

    private final ProviderRepository providerRepository;
    private final ServiceRepository serviceRepository;
    private final RequestedServiceRepository requestedServiceRepository;


    public RequestedService execute(ServiceRequest request, String userCpf) {

        Optional<Provider> provider = providerRepository.findByCpf(request.getProviderCpf());
        if (!provider.isPresent())  throw new NotFoundException("provider_not_found");

        Optional<Service> service = serviceRepository.findByProviderCpfAndServiceName(request.getProviderCpf(), request.getServiceName());
        if(!service.isPresent()) throw new NotFoundException("service_not_found");

        final RequestedService requestedService = new RequestedService();
        requestedService.setCategory(service.get().getCategory());
        requestedService.setProviderCpf(provider.get().getCpf());
        requestedService.setServiceDescription(service.get().getServiceDescription());
        requestedService.setServiceName(service.get().getServiceName());
        requestedService.setUserCpf(userCpf);
        requestedService.setValue(service.get().getValue());

        return requestedServiceRepository.save(requestedService);
    }
}
