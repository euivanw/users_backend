package dev.ivanwilhelm.users.infrastructure.config;

import dev.ivanwilhelm.users.infrastructure.api.shared.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Slf4j
@ControllerAdvice
@Order(value = HIGHEST_PRECEDENCE)
public class RestControllerErrorHandler {
    private static final String ERROR_MESSAGE_INVALID_INPUT_PARAMS = "The input parameters contain invalid values. Refer to the API documentation.";

    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorResponse methodArgumentNotValidErrorHandler(MethodArgumentNotValidException exception) {
        final var error = new ErrorResponse(ERROR_MESSAGE_INVALID_INPUT_PARAMS);
        error.setDetails(exception.getBindingResult().getAllErrors().stream()
                .map(err -> String.format("%s", err.getDefaultMessage()))
                .toList());

        return error;
    }

    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = HandlerMethodValidationException.class)
    public ErrorResponse methodValidationErrorHandler(HandlerMethodValidationException exception) {
        final var error = new ErrorResponse(ERROR_MESSAGE_INVALID_INPUT_PARAMS);
        error.setDetails(exception.getAllErrors().stream()
                .map(err -> String.format("%s", err.getDefaultMessage()))
                .toList());

        return error;
    }

    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public ErrorResponse missingServletRequestParameterErrorHandler(MissingServletRequestParameterException exception) {
        return new ErrorResponse(ERROR_MESSAGE_INVALID_INPUT_PARAMS);
    }

    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public ErrorResponse methodArgumentTypeMismatchErrorHandler(MethodArgumentTypeMismatchException exception) {
        return new ErrorResponse(ERROR_MESSAGE_INVALID_INPUT_PARAMS);
    }

    @ResponseBody
    @ResponseStatus(value = BAD_REQUEST)
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ErrorResponse httpMessageNotReadableErrorHandler(HttpMessageNotReadableException exception) {
        return new ErrorResponse("Check the informed input values. One or more input values are not in the correct format. Refer to the API documentation.");
    }
}
