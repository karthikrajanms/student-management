package com.karthik.controller;


import com.karthik.bean.ErrorMessage;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ErrorMessage getErrorMessage(MethodArgumentNotValidException ex, WebRequest request){

        Set<String> errors = ex.getFieldErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toSet());
        return getErrorMessage(request, errors);
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_GATEWAY)
    public ErrorMessage getException(Exception ex, WebRequest request){
        Set<String> errors = Collections.singleton(ex.getMessage());
        return getErrorMessageForException(request, errors);
    }

    private static ErrorMessage getErrorMessage(WebRequest request, Set<String> errors) {
        return new ErrorMessage("Unable to process request",
                request.getDescription(false),
                HttpStatus.BAD_GATEWAY.value(),
                new Date(),
                errors
                );
    }
    private static ErrorMessage getErrorMessageForException(WebRequest request, Set<String> errors) {
        return new ErrorMessage("Please Contact The Administrator. ",
                request.getDescription(false),
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                new Date(),
                errors
        );
    }
}
