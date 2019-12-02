package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.exeception.ExeceptionUserAlreadyRegister;
import com.example.projetoIntegrado.request.CreateUser;
import domain.UserState;
import domain.User;
import com.example.projetoIntegrado.database.UserRepository;
import domain.UserStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Optional;

@Service
@Transactional
public class CreateUserUsecase {

    private final UserRepository userRepository;
    private final ValidateCpfUsecase validateCpfUsecase;

    public CreateUserUsecase(UserRepository userRepository,
                             ValidateCpfUsecase validateCpfUsecase) {
        this.userRepository = userRepository;
        this.validateCpfUsecase = validateCpfUsecase;
    }

    public User execute(final CreateUser request) {

        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getRg(), "RG should not be null or empty");
        Assert.hasText(request.getSenha(), "Password should not be null or empty");

        if (validateCpfUsecase.execute(request.getCpf()) != UserState.VALID)
            throw new IllegalArgumentException("invalid_cpf");

        String cpf = validateCpfUsecase.removeCaracteresEspeciais(request.getCpf());

        Optional<User> userInRepo = userRepository.findByCpf(cpf);
        if (userInRepo.isPresent()) throw new ExeceptionUserAlreadyRegister("user_already_exist");

        final User user = new User();
        user.setUserName(request.getUserName());
        user.setCpf(cpf);
        user.setSenha(request.getSenha());
        user.setCreatedDate(LocalDate.now());
        user.setRg(validateCpfUsecase.removeCaracteresEspeciais(request.getRg()));
        user.setStatus(UserStatus.NORMAL);
        userRepository.save(user);
        return user;
    }
}
