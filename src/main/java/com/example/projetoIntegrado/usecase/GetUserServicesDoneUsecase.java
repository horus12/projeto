package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.RequestedServiceRepository;
import domain.RequestedService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class GetUserServicesDoneUsecase {

    private final RequestedServiceRepository requestedServiceRepository;

    public List<RequestedService> execute (final String userCpf) {
        return requestedServiceRepository.findAllByCpf(userCpf);
    }
}
