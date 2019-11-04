package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.LoginResponse;
import com.example.projetoIntegrado.usecase.domain.LoginState;
import domain.User;

public class LoginConverter {

    public static LoginResponse toVo(final LoginState login) {
        return LoginResponse.builder()
                .id(login.getId())
                .role(login.getRole())
                .build();
    }
}

