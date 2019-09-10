package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.LoginState;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValidateResponse {


    private LoginState type;

    @Override
    public String toString() {
        return "Cpf{" +
                "status='" + type +
                '}';
    }
}
