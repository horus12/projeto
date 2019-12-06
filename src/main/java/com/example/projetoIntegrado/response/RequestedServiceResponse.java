package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestedServiceResponse {

    private String userCpf;

    private String providerCpf;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;
}
