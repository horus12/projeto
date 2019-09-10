package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.ValidateResponse;
import domain.LoginState;

public class ValidateCpfConverter {

    public static ValidateResponse toVo(final LoginState type) {
        ValidateResponse validateResponse = ValidateResponse.builder().type(type).build();
        return validateResponse;
    }
}
