package com.misaelnt.formula1.exception.error404;

public class DriverNotFoundException extends RuntimeException {
    public DriverNotFoundException() {
        super("The driver was not found.");
    }
}
