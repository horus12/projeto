package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.GetServicesResponse;
import com.example.projetoIntegrado.response.ServiceResponse;
import com.example.projetoIntegrado.usecase.domain.LoginState;
import domain.ServiceDomain;

public class ServiceConverter {
    public static ServiceResponse toVo(final ServiceDomain service) {
        return ServiceResponse.builder()
            .category(service.getCategory())
            .serviceDescription(service.getServiceDescription())
            .providerName(service.getProviderName())
            .serviceName(service.getServiceName())
            .value(service.getValue())
            .build();
    }
}
