package com.stackroute.trackservice.exception;

public class TrackAlreadyExistException extends Exception {
    private String message;

    public TrackAlreadyExistException(String message) {
        super(message);
        System.out.println(message);
        this.message = message;
    }

    public TrackAlreadyExistException() {
    }
}