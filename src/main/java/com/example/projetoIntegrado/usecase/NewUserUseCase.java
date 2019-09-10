package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.exeception.ExeceptionUserAlreadyRegister;
import com.example.projetoIntegrado.request.CreateUserModel;
import domain.LoginState;
import domain.User;
import domain.UserRepository;
import domain.UserStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Service
@Transactional
public class NewUserUseCase {

    private final UserRepository userRepository;
    private final ValidateCpfUseCse validateCpfUseCse;

    public NewUserUseCase(UserRepository userRepository,
                          ValidateCpfUseCse validateCpfUseCse) {
        this.userRepository = userRepository;
        this.validateCpfUseCse = validateCpfUseCse;
    }

    public User execute(final CreateUserModel request) {
        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getRg(), "RG should not be null or empty");
        Assert.hasText(request.getSenha(), "Password should not be null or empty");


        if (validateCpfUseCse.execute(request.getCpf()) != LoginState.VALID)
            throw new IllegalArgumentException("invalid cpf");

        String cpf = validateCpfUseCse.removeCaracteresEspeciais(request.getCpf());

        User userInRepo = userRepository.findByCpf(cpf);
        if (userInRepo != null)
            throw  new ExeceptionUserAlreadyRegister("user already exist");

        final User user = new User();
        user.setUserName(request.getUserName());
        user.setCpf(cpf);
        user.setSenha(request.getSenha());
        user.setCreatedDate(LocalDate.now());
        user.setRg(validateCpfUseCse.removeCaracteresEspeciais(request.getRg()));
        user.setStatus(UserStatus.NORMAL);
        userRepository.save(user);
        return user;
    }
}
