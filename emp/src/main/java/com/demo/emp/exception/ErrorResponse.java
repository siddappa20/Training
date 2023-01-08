package com.demo.emp.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

    private int statusCode;
    private String message;

    public ErrorResponse(String message)
    {
        super();
        this.message = message;
    }

    public ErrorResponse( String message , int statusCode) {
        super();
        this.statusCode = statusCode;
        this.message = message;
    }

}
