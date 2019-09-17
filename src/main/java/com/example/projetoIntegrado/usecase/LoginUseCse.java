package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.exeception.ExeceptionUserAlreadyRegister;
import com.example.projetoIntegrado.exeception.GenericExeption;
import com.example.projetoIntegrado.exeception.NotFoundException;
import domain.User;
import domain.UserRepository;
import domain.UserStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginUseCse {
    private final UserRepository userRepository;

    public LoginUseCse(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String cpf, final String senha) {

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
