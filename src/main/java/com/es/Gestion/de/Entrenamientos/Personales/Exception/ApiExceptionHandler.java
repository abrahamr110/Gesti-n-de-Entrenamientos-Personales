package com.es.Gestion.de.Entrenamientos.Personales.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler()
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorMessageForClient handleBadRequest(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler()
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ErrorMessageForClient handleUnauthorized(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler()
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public ErrorMessageForClient handleForbidden(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler()
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorMessageForClient handleNotFound(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient(ex.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler()
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorMessageForClient handleInternalServerError(HttpServletRequest request, Exception ex) {
        return new ErrorMessageForClient(ex.getMessage(), request.getRequestURI());
    }
}
