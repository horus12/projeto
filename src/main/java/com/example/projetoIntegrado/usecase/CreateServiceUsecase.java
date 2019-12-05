package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ServiceRepository;
import com.example.projetoIntegrado.request.CreateServiceRequest;
import domain.Service;
import lombok.RequiredArgsConstructor;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class CreateServiceUsecase {

    private final ServiceRepository serviceRepository;

    public Service execute(CreateServiceRequest createServiceRequest) {

        Service service = new Service();
        service.setCategory(createServiceRequest.getCategory());
        service.setProviderCpf(createServiceRequest.getProviderCpf());
        service.setProviderName(createServiceRequest.getProviderName());
        service.setServiceDescription(createServiceRequest.getServiceDescription());
        service.setServiceName(createServiceRequest.getServiceName());
        service.setValue(createServiceRequest.getValue());
        return serviceRepository.save(service);

    }

}
