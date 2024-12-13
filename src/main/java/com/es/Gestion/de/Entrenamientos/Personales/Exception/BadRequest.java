package com.es.Gestion.de.Entrenamientos.Personales.Exception;

public class BadRequest extends RuntimeException {
    private static final String Descripcion="Bad Request";
    public BadRequest(String message,int httpStatusCode) {
        super(Descripcion + ": " + message);
    }
}
