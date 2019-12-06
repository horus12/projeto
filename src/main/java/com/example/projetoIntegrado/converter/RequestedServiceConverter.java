package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.RequestedServiceResponse;
import domain.RequestedService;

import java.util.List;
import java.util.stream.Collectors;

public class RequestedServiceConverter {

    public static List<RequestedServiceResponse> toVo(final List<RequestedService> serviceRequests) {
        return serviceRequests.stream().map(RequestedServiceConverter::toServiceRequestResponse).collect(Collectors.toList());
    }

    private static RequestedServiceResponse toServiceRequestResponse(RequestedService requestedService) {
        RequestedServiceResponse requestedServiceResponse = new RequestedServiceResponse();
        requestedServiceResponse.setUserCpf(requestedService.getUserCpf());
        requestedServiceResponse.setProviderCpf(requestedService.getProviderCpf());
        requestedServiceResponse.setCategory(requestedService.getCategory());
        requestedServiceResponse.setServiceDescription(requestedService.getServiceDescription());
        requestedServiceResponse.setServiceName(requestedService.getServiceName());
        requestedServiceResponse.setValue(requestedService.getValue());
        return requestedServiceResponse;
    }
}
