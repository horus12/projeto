package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.RequestedServiceRepository;
import domain.RequestedService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class GetProviderServicesDoneUsecase {

    private final RequestedServiceRepository requestedServiceRepository;

    public List<RequestedService> execute (final String providerCpf) {
        return requestedServiceRepository.findAllByCpf(providerCpf);
    }
}
