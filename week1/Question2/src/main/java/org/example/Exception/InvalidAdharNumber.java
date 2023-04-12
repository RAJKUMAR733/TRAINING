package org.example.Exception;

public class InvalidAdharNumber extends RuntimeException{

    public InvalidAdharNumber(String message){
        super(message);
    }
}
