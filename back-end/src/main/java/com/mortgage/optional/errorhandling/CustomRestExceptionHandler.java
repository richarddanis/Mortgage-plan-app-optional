package com.mortgage.optional.errorhandling;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomRestExceptionHandler.class);

    /**
     * Build {@link ApiError} object if the request contains violation(s).
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException ex, final HttpHeaders headers, final HttpStatus status, final WebRequest request) {
        final List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(error -> String.format("%s: %s", error.getField(), error.getDefaultMessage())).collect(Collectors.toList());
        ex.getBindingResult().getGlobalErrors().stream().map(error -> String.format("%s: %s", error.getObjectName(), error.getDefaultMessage())).forEach(errors::add);
        final ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);

        LOGGER.error(String.format("Cannot process the given request: %s", apiError));
        return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
    }
}
