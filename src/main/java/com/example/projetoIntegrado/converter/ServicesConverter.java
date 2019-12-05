package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.GetServicesResponse;
import com.example.projetoIntegrado.response.LoginResponse;
import com.example.projetoIntegrado.usecase.domain.LoginState;
import domain.ServiceDomain;

import java.util.List;
import java.util.stream.Collectors;

public class ServicesConverter {

    public static GetServicesResponse toVo(final List<ServiceDomain> login) {
        return GetServicesResponse.builder()
            .serviceResponses(login.stream().map(ServiceConverter::toVo).collect(Collectors.toList()))
            .build();
    }
}

