package com.github.daniilandco.alloyintegration.response;

public record RestResponse(
        String message,
        Object body
) {
    public RestResponse(String message) {
        this(message, null);
    }
}
