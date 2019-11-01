package com.example.projetoIntegrado.http;

import com.example.projetoIntegrado.converter.LoginConverter;
import com.example.projetoIntegrado.converter.ValidateCpfConverter;
import com.example.projetoIntegrado.request.CreateProvider;
import com.example.projetoIntegrado.request.CreateUser;
import com.example.projetoIntegrado.request.Login;
import com.example.projetoIntegrado.response.LoginResponse;
import com.example.projetoIntegrado.response.ValidateResponse;
import com.example.projetoIntegrado.usecase.CreateProviderUsecase;
import com.example.projetoIntegrado.usecase.CreateUserUsecase;
import com.example.projetoIntegrado.usecase.LoginUsecase;
import com.example.projetoIntegrado.usecase.ValidateCpfUsecase;
import domain.UserState;
import domain.Provider;
import domain.User;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/")
@Data
public class Controller {

    private final LoginUsecase loginUsecase;
    private final CreateUserUsecase createUserUseCase;
    private final CreateProviderUsecase createProviderUsecase;
    private final ValidateCpfUsecase validateCpfUsecase;

    @PostMapping(value = "/Login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LoginResponse Login(@RequestBody Login login) {

        return LoginConverter.toVo(loginUsecase.execute(login.getUserName(), login.getSenha()));
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> CreateUser(@RequestBody @Valid CreateUser createUser) {

        final User user = createUserUseCase.execute(createUser);

        if (user != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/provider", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> CreateProvider(@RequestBody @Valid CreateProvider createProvider) {

        final Provider provider = createProviderUsecase.execute(createProvider);
        if (provider != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/cpf/{cpf}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ValidateResponse> ValidateCpf(@PathVariable(value = "cpf") String cpf) {

        final ValidateResponse validateResponse = ValidateCpfConverter.toVo(validateCpfUsecase.execute(cpf));
        if (validateResponse.getType() == UserState.INVALID)
            return new ResponseEntity<>(validateResponse, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(validateResponse, HttpStatus.OK);
    }

}
