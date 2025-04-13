package dev.ivanwilhelm.users.infrastructure.api.users;

import dev.ivanwilhelm.users.domain.users.UserNotFoundException;
import dev.ivanwilhelm.users.domain.users.UsersException;
import dev.ivanwilhelm.users.infrastructure.api.shared.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice(basePackageClasses = UsersController.class)
public class UsersErrorHandler {
    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = UserNotFoundException.class)
    public ErrorResponse userDoesNotExistsErrorHandler(UserNotFoundException exception) {
        return new ErrorResponse(exception.getMessage());
    }

    @ResponseBody
    @ResponseStatus(value = INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = UsersException.class)
    public ErrorResponse usersErrorHandler(UsersException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}
