package com.github.daniilandco.alloyintegration.exception;

import com.github.daniilandco.alloyintegration.dto.model.response.RestResponse;
import feign.FeignException;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.charset.Charset;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String API_CALL_ERROR = "ALLOY API CALL ERROR";
    private static final String UNKNOWN_ERROR = "UNKNOWN ERROR";

    @ExceptionHandler(value = FeignException.class)
    public ResponseEntity<?> handler(FeignException exception) throws UnknownErrorException, ParseException {
        JSONParser parser = new JSONParser(
                Charset.defaultCharset()
                        .decode(
                                exception
                                        .responseBody().orElseThrow(() -> new UnknownErrorException(API_CALL_ERROR))
                        )
                        .toString()
        );

        return ResponseEntity
                .badRequest()
                .body(new RestResponse(
                        API_CALL_ERROR,
                        parser.object()
                ));
    }

    @ExceptionHandler(value = UnknownErrorException.class)
    public ResponseEntity<?> handler(UnknownErrorException exception) {
        return ResponseEntity
                .badRequest()
                .body(new RestResponse(
                        UNKNOWN_ERROR,
                        exception.getMessage()
                ));
    }

    @ExceptionHandler(value = ParseException.class)
    public ResponseEntity<?> handler(ParseException exception) {
        return ResponseEntity
                .badRequest()
                .body(new RestResponse(
                        exception.getMessage()
                ));
    }

    @ExceptionHandler(value = PersonAlreadyExistsException.class)
    public ResponseEntity<?> handler(PersonAlreadyExistsException exception) {
        return ResponseEntity
                .badRequest()
                .body(new RestResponse(
                        exception.getMessage()
                ));
    }
}
