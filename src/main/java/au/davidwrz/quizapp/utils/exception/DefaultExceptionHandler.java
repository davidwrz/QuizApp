package au.davidwrz.quizapp.utils.exception;

import au.davidwrz.quizapp.modules.user.register.application.AlreadyRegisteredUserException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(AlreadyRegisteredUserException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(AlreadyRegisteredUserException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleException(InsufficientAuthenticationException e) {
        return new ErrorResponse(e.getMessage());
    }

    public record ErrorResponse(String message) {
    }
}