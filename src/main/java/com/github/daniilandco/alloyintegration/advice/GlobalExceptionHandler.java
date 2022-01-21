package com.github.daniilandco.alloyintegration.advice;

import com.github.daniilandco.alloyintegration.dto.response.ErrorDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseFailureException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String API_CALL_ERROR = "ALLOY API CALL ERROR";

    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<ErrorDTO> handler(FeignException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(exception.status()), API_CALL_ERROR, exception.getMessage()));
    }

    @ExceptionHandler(value = DatabaseFailureException.class)
    public ResponseEntity<ErrorDTO> handler(DatabaseFailureException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(HttpStatus.BAD_REQUEST.toString(), API_CALL_ERROR, exception.getMessage()));
    }
}
