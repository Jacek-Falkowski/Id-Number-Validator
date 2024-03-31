package com.mycompany.model;

/**
 * Custom exception class for handling validation errors in the Validator class.
 *
 * @author jfalkowski
 * @version 3.0
 */
public class ValidatorException extends Exception {

    /**
     * Constructs a new ValidatorException with the specified error message.
     *
     * @param message The error message to be associated with this exception.
     */
    public ValidatorException(String message) {
        super(message);
    }
}
