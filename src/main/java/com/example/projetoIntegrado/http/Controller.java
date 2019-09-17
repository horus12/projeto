package com.example.projetoIntegrado.http;

import com.example.projetoIntegrado.converter.LoginConverter;
import com.example.projetoIntegrado.converter.ValidateCpfConverter;
import com.example.projetoIntegrado.request.CreateUserModel;
import com.example.projetoIntegrado.request.LoginUserModel;
import com.example.projetoIntegrado.response.LoginResponse;
import com.example.projetoIntegrado.response.ValidateResponse;
import com.example.projetoIntegrado.usecase.LoginUseCse;
import com.example.projetoIntegrado.usecase.NewUserUseCase;
import com.example.projetoIntegrado.usecase.ValidateCpfUseCse;
import domain.LoginState;
import domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/user")
public class Controller {

    private final LoginUseCse loginUseCse;
    private final NewUserUseCase newUserUseCase;
    private final ValidateCpfUseCse validateCpfUseCse;

    public Controller(LoginUseCse loginUseCse,
                      NewUserUseCase newUserUseCase,
                      ValidateCpfUseCse validateCpfUseCse) {
        this.loginUseCse = loginUseCse;
        this.newUserUseCase = newUserUseCase;
        this.validateCpfUseCse = validateCpfUseCse;
    }

    @PostMapping(value = "/Login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LoginResponse Login(@RequestBody LoginUserModel loginUserModel) {
        final LoginResponse loginResponse = LoginConverter.toVo(loginUseCse.execute(loginUserModel.getCpf(), loginUserModel.getSenha()));
        return loginResponse;
    }

    @PostMapping(value = "/createUser", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> CreateUser(@RequestBody @Valid CreateUserModel createUserModel) {

        final User user = newUserUseCase.execute(createUserModel);

        if (user != null) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/cpf/{cpf}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ValidateResponse> ValidateCpf(@PathVariable(value = "cpf") String cpf) {

        final ValidateResponse validateResponse = ValidateCpfConverter.toVo(validateCpfUseCse.execute(cpf));
        if (validateResponse.getType() == LoginState.INVALID)
            return new ResponseEntity<>(validateResponse, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(validateResponse, HttpStatus.OK);
    }

}
