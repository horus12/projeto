package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.ServiceResponse;
import domain.Service;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesConverter {

    public static List<ServiceResponse> toVo(final List<Service> login) {
        return login.stream().map(ServicesConverter::toServiceResponse).collect(Collectors.toList());
    }

    private static ServiceResponse toServiceResponse(Service service) {
        ServiceResponse serviceResponse = new ServiceResponse();
        serviceResponse.setCategory(service.getCategory());
        serviceResponse.setProviderName(service.getProviderName());
        serviceResponse.setServiceDescription(service.getServiceDescription());
        serviceResponse.setValue(service.getValue());
        return serviceResponse;
    }
}

