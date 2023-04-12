package org.example;

import org.example.Exception.InvalidAdharNumber;
import org.example.Exception.InvalidDateOfBirth;
import org.example.Exception.InvalidNameException;
import org.example.Service.CreateUserName;
import org.example.Service.ValidateDetails;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scn=new Scanner(System.in);
        String name,date,adharnumber;

        try{
            name=ValidateDetails.validateName();
            LocalDate formattedDate = ValidateDetails.validateDateOfBirth();
            String adharNumber=ValidateDetails.validateAdharNumber();
            System.out.println(CreateUserName.createUserName(name,formattedDate.getDayOfMonth(),formattedDate.getYear()
                    ,adharNumber));

        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
