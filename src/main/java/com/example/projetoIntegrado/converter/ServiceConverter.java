package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.request.ServiceRequest;
import domain.ServiceDomain;

public class ServiceConverter {
    public static ServiceDomain converter(ServiceRequest serviceRequest) {
        return ServiceDomain.builder().userName(serviceRequest.getUserName())
                .providerName(serviceRequest.getProviderName()).serviceRequested(serviceRequest.getServiceRequested()).build();
    }
}
