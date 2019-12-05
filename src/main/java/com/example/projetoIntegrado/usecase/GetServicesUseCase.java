package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ServiceMongoRepository;
import com.example.projetoIntegrado.database.ServiceRepository;
import domain.ServiceDomain;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@RequiredArgsConstructor
public class GetServicesUseCase {
    private final ServiceMongoRepository serviceRepository;

    public List<ServiceDomain> execute() {

        List<ServiceDomain> list = serviceRepository.findAll();


        return list;

    }
}
