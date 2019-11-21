package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.database.ProviderRepository;
import com.example.projetoIntegrado.database.UserRepository;
import com.example.projetoIntegrado.exeception.GenericExeption;
import com.example.projetoIntegrado.exeception.NotFoundException;
import com.example.projetoIntegrado.usecase.domain.LoginState;
import domain.Provider;
import domain.User;
import domain.UserStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.example.projetoIntegrado.domain.UserRole.PROVIDER;
import static com.example.projetoIntegrado.domain.UserRole.USER;

@Service
@Data
@RequiredArgsConstructor
public class LoginUsecase {
    private final UserRepository userRepository;
    private final ProviderRepository providerRepository;

    public LoginState execute(final String name, final String senha) throws NotFoundException {

        LoginState loginState = new LoginState();

        Optional<User> userBd = userRepository.findByUserName(name);
        if (userBd.isPresent()) {
            loginState.setRole(USER);
            User user = userBd.get();
            loginState.setId(user.getId());
            if (!user.getSenha().equals(senha))
                throw new NotFoundException("wrong_password");
            else if (user.getStatus() == UserStatus.BLOCKED || user.getStatus() == UserStatus.DELETED)
                throw new GenericExeption("user_blocked_or_deleted");
            else
                loginState.setUserName(user.getUserName());
        } else {
            Optional<Provider> providerBd = providerRepository.findByUserName(name);
            if (providerBd.isPresent()) {
                loginState.setRole(PROVIDER);
                Provider provider = providerBd.get();
                loginState.setId(provider.getId());
                if (!provider.getSenha().equals(senha))
                    throw new NotFoundException("wrong_password");
                else if (provider.getStatus() == UserStatus.BLOCKED || provider.getStatus() == UserStatus.DELETED)
                    throw new GenericExeption("provider_blocked_or_deleted");
                else
                    loginState.setUserName(provider.getUserName());
            }
        }
        if (null == loginState.getUserName())  {
            throw new NotFoundException("User not found");
        }
        return loginState;
    }

}
