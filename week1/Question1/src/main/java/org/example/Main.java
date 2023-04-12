package org.example;

import org.example.model.Openings;
import org.example.service.SalaryCalculater;
import org.example.service.TechStackValidator;

import java.util.Scanner;

import static org.example.model.Openings.*;
import static org.example.service.TechStackValidator.techInput;

public class Main {
    public static void main(String[] args) throws Exception {
        try{
            TechStackValidator.techValidator();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            TechStackValidator.techValidator();
        }
    }
}