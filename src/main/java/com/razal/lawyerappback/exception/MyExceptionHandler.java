package com.razal.lawyerappback.exception;

import com.razal.lawyerappback.exception.custom.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;


@ControllerAdvice //this class will be applied to all @Controllers
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    //handle MethodArgumentNotValidException -HTTP Error 400 (Bad Request)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorDetails err = new ErrorDetails("From MethodArgumentNotValidException ",ex.getMessage(),new Date());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    //405 (Method not allowed)
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        ErrorDetails err = new ErrorDetails("From HttpRequestMethodNotSupported ",ex.getMessage(),new Date());
        return new ResponseEntity<>(err,HttpStatus.METHOD_NOT_ALLOWED);
    }

    //custom - NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){

        ErrorDetails err = new ErrorDetails("From handleNotFoundException: " + request.getDescription(false),ex.getMessage(),new Date());
        return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
    }
}
