package org.example.Exceptions;

public class InvalidTechStackException extends RuntimeException{
    public InvalidTechStackException(String message) {
        super(message);
    }
}
