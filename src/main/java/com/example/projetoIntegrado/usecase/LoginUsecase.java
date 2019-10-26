package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.exeception.GenericExeption;
import com.example.projetoIntegrado.exeception.NotFoundException;
import domain.ProviderRepository;
import domain.User;
import domain.UserRepository;
import domain.UserStatus;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Data
public class LoginUsecase {
    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;


    //TODO --  Refactor login by Username
    public User execute(final String cpf, final String senha) throws NotFoundException {

        User user = userRepository.findByCpf(cpf);

        if (user == null)
            throw new NotFoundException("user_not_found");

        if (!user.getSenha().equals(senha))
            throw new NotFoundException("wrong_password");
        else if (user.getStatus() == UserStatus.BLOCKED || user.getStatus() == UserStatus.DELETED)
            throw new GenericExeption("user_blocked_or_deleted");
        else
            return user;
    }

}
