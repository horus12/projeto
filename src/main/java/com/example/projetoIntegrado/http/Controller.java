package com.example.projetoIntegrado.http;

import com.example.projetoIntegrado.converter.LoginConverter;
import com.example.projetoIntegrado.converter.RequestedServiceConverter;
import com.example.projetoIntegrado.converter.ServicesConverter;
import com.example.projetoIntegrado.converter.ValidateCpfConverter;
import com.example.projetoIntegrado.request.*;
import com.example.projetoIntegrado.response.LoginResponse;
import com.example.projetoIntegrado.response.RequestedServiceResponse;
import com.example.projetoIntegrado.response.ServiceResponse;
import com.example.projetoIntegrado.response.ValidateResponse;
import com.example.projetoIntegrado.usecase.*;
import domain.*;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/")
@Data
@CrossOrigin
public class Controller {

    private final LoginUsecase loginUsecase;
    private final CreateUserUsecase createUserUseCase;
    private final CreateProviderUsecase createProviderUsecase;
    private final ValidateCpfUsecase validateCpfUsecase;
    private final AskForProviderUsecase askForProviderUsecase;
    private final CreateServiceUsecase createServiceUsecase;
    private final GetServicesUseCase getServicesUseCase;
    private final GetProviderServicesDoneUsecase getProviderServicesDoneUsecase;
    private final GetUserServicesDoneUsecase getUserServicesDoneUsecase;

    @PostMapping(value = "/Login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LoginResponse Login(@RequestBody Login login) {

        return LoginConverter.toVo(loginUsecase.execute(login.getCpf(), login.getSenha()));
    }

    @PostMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<HttpStatus> CreateUser(@RequestBody @Valid CreateUser createUser) {
        User user;
        try {
            user = createUserUseCase.execute(createUser);
        } catch (Exception e) {
            if (e.getMessage().equals("user_already_exist"))
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            if (e.getMessage().equals("invalid_cpf"))
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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

    @PostMapping(value = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> CreateService(@RequestBody @Valid CreateServiceRequest createServiceRequest) {
        Service service = createServiceUsecase.execute(createServiceRequest);
        if (service == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/service/{userCpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ServiceRequest(@RequestBody @Valid ServiceRequest serviceRequest, @PathVariable(value = "userCpf") String userCpf) {
        RequestedService requestedService = askForProviderUsecase.execute(serviceRequest, userCpf);
        if (requestedService == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/service/{providerCpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> ServiceRequest(@PathVariable(value = "providerCpf") String providerCpf) {
        List<RequestedServiceResponse> requestedServices = RequestedServiceConverter.toVo(getProviderServicesDoneUsecase.execute(providerCpf));
        if (requestedServices == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestedServices, HttpStatus.OK);
    }

    @GetMapping(value = "/service/{userCpf}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> UserServiceRequest(@PathVariable(value = "userCpf") String userCpf) {
        List<RequestedServiceResponse> requestedServices = RequestedServiceConverter.toVo(getUserServicesDoneUsecase.execute(userCpf));
        if (requestedServices == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestedServices, HttpStatus.OK);
    }


    @GetMapping(value = "/service", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> GetServices() {
        List<ServiceResponse> listServices = ServicesConverter.toVo(getServicesUseCase.execute());
        if (listServices.isEmpty()) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(listServices, HttpStatus.OK);
    }

}
