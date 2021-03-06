package com.example.projetoIntegrado.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ServiceRequest {

    @NotEmpty
    @NotNull
    private String providerCpf;

    @NotEmpty
    @NotNull
    private String serviceName;

}
