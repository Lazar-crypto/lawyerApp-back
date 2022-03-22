package com.razal.lawyerappback.exception;

import com.razal.lawyerappback.exception.custom.NotFoundException;
import com.razal.lawyerappback.response.CustomResponse;
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
import java.util.Map;
import java.util.NoSuchElementException;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.*;


@ControllerAdvice //this class will be applied to all @Controllers
public class MyExceptionHandler extends ResponseEntityExceptionHandler {

    //handle MethodArgumentNotValidException -HTTP Error 400 (Bad Request)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .msg(ex.getMessage())
                        .reason("Validation error")
                        .status(BAD_REQUEST)
                        .statusCode(BAD_REQUEST.value())
                        .developerMsg("From: " + MyExceptionHandler.class)
                        .build()
        );
    }

    //405 (Method not allowed)
    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
            HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .msg(ex.getMessage())
                        .reason("User provided wrong Http method")
                        .status(METHOD_NOT_ALLOWED)
                        .statusCode(METHOD_NOT_ALLOWED.value())
                        .developerMsg("From: " + MyExceptionHandler.class)
                        .build()
        );
    }

    //custom - NotFoundException
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException ex, WebRequest request){
        return ResponseEntity.ok(
                CustomResponse.builder()
                        .timeStamp(now())
                        .msg(ex.getMessage())
                        .reason("The object does not exist in database")
                        .status(NOT_FOUND)
                        .statusCode(NOT_FOUND.value())
                        .developerMsg("From: " + MyExceptionHandler.class)
                        .build()
        );


    }



}
