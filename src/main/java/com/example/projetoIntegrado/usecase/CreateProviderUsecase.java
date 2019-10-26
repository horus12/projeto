package com.example.projetoIntegrado.usecase;

import com.example.projetoIntegrado.exeception.ExeceptionUserAlreadyRegister;
import com.example.projetoIntegrado.request.CreateProvider;
import domain.LoginState;
import domain.Provider;
import domain.ProviderRepository;
import domain.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateProviderUsecase {

    private final ProviderRepository providerRepository;
    private final ValidateCpfUsecase validateCpfUsecase;

    public Provider execute(final CreateProvider request) {
        Assert.hasText(request.getUserName(), "UserName should not be null or empty");
        Assert.hasText(request.getCpf(), "cpf should not be null or empty");
        Assert.hasText(request.getRg(), "RG should not be null or empty");
        Assert.hasText(request.getSenha(), "Password should not be null or empty");


        if (validateCpfUsecase.execute(request.getCpf()) != LoginState.VALID)
            throw new IllegalArgumentException("invalid cpf");

        String cpf = validateCpfUsecase.removeCaracteresEspeciais(request.getCpf());

        Provider provider = providerRepository.findByCpf(cpf);
        if (provider != null)
            throw  new ExeceptionUserAlreadyRegister("user already exist");

        final Provider providerCreated = new Provider();
        providerCreated.setUserName(request.getUserName());
        providerCreated.setCpf(cpf);
        providerCreated.setSenha(request.getSenha());
        providerCreated.setCreatedDate(LocalDate.now());
        providerCreated.setRg(validateCpfUsecase.removeCaracteresEspeciais(request.getRg()));
        providerCreated.setStatus(UserStatus.NORMAL);
        providerRepository.save(providerCreated);
        return providerCreated;
    }
}
