package org.example.Exceptions;

public class InvalidSalaryExpressionException extends RuntimeException{
    public InvalidSalaryExpressionException(String message) {
        super(message);
    }
}
