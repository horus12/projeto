package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class RequestedServiceResponse {

    private String userCpf;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;
}
