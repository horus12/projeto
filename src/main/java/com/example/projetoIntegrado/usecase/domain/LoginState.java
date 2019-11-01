package com.example.projetoIntegrado.usecase.domain;

import com.example.projetoIntegrado.domain.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginState {
    String userName;
    String id;
    UserRole role;
}
