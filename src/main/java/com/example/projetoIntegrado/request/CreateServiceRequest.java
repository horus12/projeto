package com.example.projetoIntegrado.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class CreateServiceRequest {

    @NotEmpty
    @NotNull
    private String providerCpf;

    @NotEmpty
    @NotNull
    private String serviceName;

    @NotEmpty
    @NotNull
    private String serviceDescription;

    @NotEmpty
    @NotNull
    private String category;

    @NotNull
    private Float  value;

}
