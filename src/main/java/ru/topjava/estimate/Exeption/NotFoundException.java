package ru.topjava.estimate.Exeption;

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