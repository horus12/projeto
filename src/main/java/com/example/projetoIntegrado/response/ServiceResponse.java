package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ServiceResponse {

    private String providerName;

    private String providerCpf;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;

}
