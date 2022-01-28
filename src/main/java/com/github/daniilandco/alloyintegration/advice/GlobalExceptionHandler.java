package com.github.daniilandco.alloyintegration.advice;

import com.github.daniilandco.alloyintegration.dto.response.ErrorDTO;
import com.github.daniilandco.alloyintegration.exception.DatabaseTransactionFailureException;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

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
                .body(new ErrorDTO(String.valueOf(exception.status()),
                        ResponseMessage.API_CALL_ERROR.message,
                        exception.getMessage())
                );
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
                .body(new ErrorDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        ResponseMessage.DATABASE_TRANSACTION_ERROR.message,
                        exception.getMessage())
                );
    }

    /**
     * This method handles MethodArgumentNotValidException that can occur
     * when providing to service PersonDTO with invalid email or SSN.
     *
     * @param exception caught PersonRequestIsNullException instance which must be handled
     * @return ResponseEntity with Error as body which contains information about occurred exception
     * @see ErrorDTO
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handler(final MethodArgumentNotValidException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        ResponseMessage.INVALID_DATA_FORMAT_ERROR.message,
                        exception.getAllErrors().get(0).getDefaultMessage())
                );
    }

    /**
     * This method handles ConstraintViolationException that can occur
     * when providing to service null PersonDTO.
     *
     * @param exception caught ConstraintViolationException instance which must be handled
     * @return ResponseEntity with Error as body which contains information about occurred exception
     * @see ErrorDTO
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handler(final ConstraintViolationException exception) {
        return ResponseEntity
                .badRequest()
                .body(new ErrorDTO(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                        ResponseMessage.INVALID_DATA_FORMAT_ERROR.message,
                        exception.getMessage())
                );
    }
}
