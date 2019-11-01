package com.example.projetoIntegrado.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import domain.UserState;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValidateResponse {

    private UserState type;

    @Override
    public String toString() {
        return "Cpf{" +
                "status='" + type +
                '}';
    }
}
