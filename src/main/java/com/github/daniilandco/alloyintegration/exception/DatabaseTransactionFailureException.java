package com.github.daniilandco.alloyintegration.exception;

/**
 * Class of the DatabaseTransactionFailureException exception
 * which is thrown when database transaction goes wrong
 *
 * @author com.github.daniilandco
 * @version 1.0
 */
public class DatabaseTransactionFailureException extends Exception {
    public DatabaseTransactionFailureException(String message) {
        super(message);
    }
}
