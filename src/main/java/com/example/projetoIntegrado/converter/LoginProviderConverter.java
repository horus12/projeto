package com.example.projetoIntegrado.converter;

import com.example.projetoIntegrado.response.LoginResponse;
import domain.Provider;

public class LoginProviderConverter {

    public static LoginResponse toVo(final Provider provider) {
        return LoginResponse.builder()
                .id(provider.getId())
                .build();
    }
}

