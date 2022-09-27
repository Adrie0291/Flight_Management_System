package com.sda.group2.exceptions;

public class FlightMappingException extends Exception {

    private String line;

    public FlightMappingException(String message, String line) {
        super(message);
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
