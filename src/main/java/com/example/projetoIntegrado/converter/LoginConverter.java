package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.LoginResponse;
import domain.User;

public class LoginConverter {

    public static LoginResponse toVo(final User user) {
        return LoginResponse.builder()
                .id(user.getCpf())
                .build();
    }
}

