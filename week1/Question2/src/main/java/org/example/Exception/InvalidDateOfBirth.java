package org.example.Exception;

public class InvalidDateOfBirth extends RuntimeException{

    public InvalidDateOfBirth(String message)
    {
        super(message);
    }
}
