package com.example.projetoIntegrado.usecase;

import domain.User;
import domain.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class LoginUseCse {
    private final UserRepository userRepository;

    public LoginUseCse(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(final String username, final String senha) {

        final User user = new User();
        user.setCpf(username);
        userRepository.save(user);
        return user;
    }

}
