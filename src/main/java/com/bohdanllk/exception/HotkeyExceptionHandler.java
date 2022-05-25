package com.bohdanllk.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolationException;


@RestControllerAdvice(basePackages = "com.bohdanllk.controller")
public class HotkeyExceptionHandler {


    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleBadRequest(IllegalArgumentException e) {
        return e.getMessage()
                + "\n"
                + "HttpStatus: "
                + HttpStatus.BAD_REQUEST.getReasonPhrase();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public String handleNotFoundException(NotFoundException e) {
        return e.getMessage()
                + "\n"
                + "HttpStatus: "
                + HttpStatus.NOT_FOUND.getReasonPhrase();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleValidation(ConstraintViolationException e) {
        return e.getMessage()
                + "\n"
                + "Not valid data"
                + "\n"
                + "HttpStatus: "
                + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleValidation(DataIntegrityViolationException e) {
        return e.getMessage()
                + "\n"
                + "Not valid data"
                + "\n"
                + "HttpStatus: "
                + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    @ExceptionHandler(PersistenceException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleValidation(PersistenceException e) {
        return e.getMessage()
                + "\n"
                + "Not valid data"
                + "\n"
                + "HttpStatus: "
                + HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }

    @ExceptionHandler(ParserException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public String handleValidation(ParserException e) {
        return e.getMessage()
                + "\n"
                + "Not valid data"
                + "\n"
                + "HttpStatus: "
                + HttpStatus.BAD_REQUEST.getReasonPhrase();
    }


}
