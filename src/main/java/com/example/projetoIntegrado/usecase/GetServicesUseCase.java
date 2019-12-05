package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ServiceRepository;
import domain.Service;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@Data
@RequiredArgsConstructor
public class GetServicesUseCase {
    private final ServiceRepository serviceRepository;

    public List<Service> execute() {

        return serviceRepository.findAll();

    }
}
