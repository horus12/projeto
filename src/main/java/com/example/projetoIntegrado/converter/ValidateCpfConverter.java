package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.ValidateResponse;
import domain.UserState;

public class ValidateCpfConverter {

    public static ValidateResponse toVo(final UserState userState) {
        return ValidateResponse.builder().type(userState).build();
    }
}
