package com.github.daniilandco.alloyintegration.dto.response;

/**
 * Record which represents unified Rest response.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public record RestResponse(
        String message,
        Object body
) {
    public RestResponse(String message) {
        this(message, null);
    }
}
