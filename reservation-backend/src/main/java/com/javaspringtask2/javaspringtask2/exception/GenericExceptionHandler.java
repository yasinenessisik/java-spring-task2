package com.javaspringtask2.javaspringtask2.exception;


import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class GenericExceptionHandler extends RuntimeException {
    private HttpStatus httpStatus;
    private ErrorCode errorCode;
    private String errorMessage;
}