package com.stackroute.trackservice.exception;

public class TrackNotFoundException extends Throwable {
    private String message;

    public TrackNotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public TrackNotFoundException() {
    }
}
