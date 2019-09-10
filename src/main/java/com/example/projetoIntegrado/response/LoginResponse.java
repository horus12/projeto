package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Getter
@Setter
@Builder
public class LoginResponse {

    private String id;

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id +
                '}';
    }


}
