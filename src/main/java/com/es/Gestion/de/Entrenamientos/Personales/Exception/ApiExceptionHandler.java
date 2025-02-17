package com.es.Gestion.de.Entrenamientos.Personales.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMessageForClient handleBadRequest(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient("Invalid request", request.getRequestURI());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessageForClient handleInternalServerError(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient("Internal server error", request.getRequestURI());
    }
}

