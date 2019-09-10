package com.example.projetoIntegrado.exeception;

import lombok.Getter;

@Getter
public class ExeceptionUserAlreadyRegister extends IllegalArgumentException {

    public ExeceptionUserAlreadyRegister(String message) {
        super(message);
    }


}


