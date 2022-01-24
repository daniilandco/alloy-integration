package com.github.daniilandco.alloyintegration.advice;

import lombok.AllArgsConstructor;

/**
 * Enum with set of strings for exception titles.
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
@AllArgsConstructor
public enum ResponseMessage {
    API_CALL_ERROR("alloy api call error"),
    DATABASE_TRANSACTION_ERROR("database transaction error");

    public final String message;
}
