package com.dacuni.library.content_service.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex){
        // todo log error, warning
        log.error("Global Exception Handler : ", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return HttpStatus.INTERNAL_SERVER_ERROR;
            }

            @Override
            public ProblemDetail getBody() {
                return ProblemDetail.forStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        });
    }
}
