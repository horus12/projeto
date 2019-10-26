package com.example.projetoIntegrado.request;


import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreateUser {

    @NotNull
    private String cpf;

    @NotNull
    private String senha;

    @NotNull
    private String userName;

    @NotNull
    private String rg;

    @NotNull
    private String contact;

}


