package com.example.projetoIntegrado.request;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateUserModel {

    @NotNull
    private String cpf;

    @NotNull
    private String senha;

    @NotNull
    private String userName;

    @NotNull
    private String rg;

}


