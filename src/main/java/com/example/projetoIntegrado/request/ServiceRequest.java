package com.example.projetoIntegrado.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ServiceRequest {

    @NotEmpty
    @NotNull
    private String id;

    @NotEmpty
    @NotNull
    private String serviceName;

    private String serviceDescription;

    @NotEmpty
    @NotNull
    private String category;

    @NotEmpty
    @NotNull
    private Float value;
}
