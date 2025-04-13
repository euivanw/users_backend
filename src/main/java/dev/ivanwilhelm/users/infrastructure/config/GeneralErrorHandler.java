package dev.ivanwilhelm.users.infrastructure.config;

import dev.ivanwilhelm.users.infrastructure.api.shared.ErrorResponse;
import org.springframework.core.annotation.Order;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.UNSUPPORTED_MEDIA_TYPE;

@ControllerAdvice
@Order(value = HIGHEST_PRECEDENCE)
public class GeneralErrorHandler {
    @ResponseBody
    @ResponseStatus(value = UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(value = HttpMediaTypeNotSupportedException.class)
    public ErrorResponse mediaTypeNotSupportedErrorHandler(HttpMediaTypeNotSupportedException exception) {
        return new ErrorResponse("This API does not support the content type being sent. Please refer to the API documentation.");
    }

    @ResponseBody
    @ResponseStatus(value = NOT_FOUND)
    @ExceptionHandler(value = NoResourceFoundException.class)
    public ErrorResponse noResourceFoundErrorHandler(NoResourceFoundException exception) {
        return new ErrorResponse("The requested path was not found. Please refer to the API documentation.");
    }
}
