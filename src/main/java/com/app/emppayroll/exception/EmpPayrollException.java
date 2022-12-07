package com.app.emppayroll.exception;

// Creating customized Exception class.
public class EmpPayrollException extends RuntimeException {

    public EmpPayrollException(String message) {
        // Calling super class constructor.
        super(message);
    }
}
