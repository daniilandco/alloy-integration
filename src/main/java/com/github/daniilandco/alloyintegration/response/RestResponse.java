package com.github.daniilandco.alloyintegration.response;

import lombok.Data;

@Data
public class RestResponse {
    private String message;
    private Object body;

    public RestResponse(final String message, final Object body) {
        this.message = message;
        this.body = body;
    }

    public RestResponse(String message) {
        this.message = message;
    }
}