package com.example.projetoIntegrado.response;

import com.example.projetoIntegrado.domain.UserRole;
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

    private UserRole role;

    @Override
    public String toString() {
        return "Login{" +
                "id='" + id +
                "role='"+ role +
                '}';
    }


}
