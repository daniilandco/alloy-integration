package com.github.daniilandco.alloyintegration.dto.response;

/**
 * Record which represents unified Rest response.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public record RestResponseWrapper<T>(
        String message,
        T body
) {
}