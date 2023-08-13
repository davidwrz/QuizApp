package au.davidwrz.quizapp.modules.user.register.infrastructure.web;

import au.davidwrz.quizapp.modules.user.register.application.RegisterUserDto;
import au.davidwrz.quizapp.modules.user.register.application.RegisterUserFacade;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
class RegisterUserController {

    private final RegisterUserFacade service;

    RegisterUserController(RegisterUserFacade service) {
        this.service = service;
    }

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@Valid @RequestBody RegisterUserDto userDto) {
        String token = service.register(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header(HttpHeaders.AUTHORIZATION, token)
                .build();
    }
}
