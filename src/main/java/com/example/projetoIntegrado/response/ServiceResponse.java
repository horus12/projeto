package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@Builder
public class ServiceResponse {


    private String providerName;

    private String serviceName;

    private String serviceDescription;

    private String category;

    private Float  value;

    @Override
    public String toString(){
        return "ServiceItem{"+
            ", providerName='"+providerName+'\''+
            ", serviceName='"+serviceName+'\''+
            ", description='"+serviceDescription+'\''+
            ", category='"+category+'\''+
            ", value="+value+
            '}';
    }

}
