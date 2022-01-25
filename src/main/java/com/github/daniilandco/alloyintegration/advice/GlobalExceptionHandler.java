package com.github.daniilandco.alloyintegration.advice;

import com.github.daniilandco.alloyintegration.dto.response.ErrorDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import com.github.daniilandco.alloyintegration.exception.PersonRequestIsNullException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Advice class for handling all exception that can occur in service.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * This method handles all FeignException that can occur during service execution.
     *
     * @param exception caught FeignException instance which must be handled
     * @return ResponseEntity with Error as body which contains information about occurred exception
     * @see ErrorDTO
     */
    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<ErrorDTO> handler(final FeignException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(exception.status()), ResponseMessage.API_CALL_ERROR.message, exception.getMessage()));
    }

    /**
     * This method handles all DatabaseTransactionFailureException that occurs after database transaction error.
     *
     * @param exception caught DatabaseTransactionFailureException instance which must be handled
     * @return ResponseEntity with Error as body which contains information about occurred exception
     * @see ErrorDTO
     */
    @ExceptionHandler(value = DatabaseTransactionFailureException.class)
    public ResponseEntity<ErrorDTO> handler(final DatabaseTransactionFailureException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), ResponseMessage.DATABASE_TRANSACTION_ERROR.message, exception.getMessage()));
    }

    /**
     * This method handles PersonRequestIsNullException that can occur when providing null person dto to verification service.
     * It can occur when request body is empty, for example.
     *
     * @param exception caught PersonRequestIsNullException instance which must be handled
     * @return ResponseEntity with Error as body which contains information about occurred exception
     * @see ErrorDTO
     */
    @ExceptionHandler(value = PersonRequestIsNullException.class)
    public ResponseEntity<ErrorDTO> handler(final PersonRequestIsNullException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()), ResponseMessage.INVALID_REQUEST_BODY_ERROR.message, exception.getMessage()));
    }
}
