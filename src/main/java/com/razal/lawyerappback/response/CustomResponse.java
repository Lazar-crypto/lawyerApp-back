package com.razal.lawyerappback.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@SuperBuilder
@JsonInclude(NON_NULL) //dont include null values in the response
public class CustomResponse {

    LocalDateTime timeStamp;
    int statusCode;
    HttpStatus status;
    String reason;
    String msg;
    String developerMsg;
    Map<?,?> data;
}
