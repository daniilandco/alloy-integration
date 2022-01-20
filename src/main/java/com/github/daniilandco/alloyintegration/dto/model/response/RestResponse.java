package com.github.daniilandco.alloyintegration.dto.model.response;

public record RestResponse(
        String message,
        Object body
) {
    public RestResponse(String message) {
        this(message, null);
    }
}
