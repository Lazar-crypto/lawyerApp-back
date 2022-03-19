package com.razal.lawyerappback.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDetails {

    private final String msg;
    private final String err;
    //private final Throwable throwable;
    //private final HttpStatus httpStatus;
    private final Date timeStamp;

}
