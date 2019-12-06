package com.example.projetoIntegrado.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
@Getter
@Setter
public class Login {

        @NotNull
        private String cpf;

        @NotNull
        private String senha;

    }

