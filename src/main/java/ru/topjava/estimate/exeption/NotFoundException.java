package ru.topjava.estimate.exeption;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }

    public NotFoundException(Exception e) {
        this.getStackTrace();
    }
}