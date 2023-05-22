package com.example.week6.service;

public class RunningClass {
    public static void main(String[]args)
    {

        try{
            Format.takingInput();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
