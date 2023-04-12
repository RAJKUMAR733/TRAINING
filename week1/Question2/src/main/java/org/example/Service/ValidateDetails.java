package org.example.Service;

import org.example.Exception.InvalidNameExpressionException;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidateDetails {

    final static String DATE_FORMAT = "dd-MM-yyyy";
    static Scanner scn=new Scanner(System.in);
    public static String validateName()
    {

        try {
            System.out.print("Enter your Name(FirstName MiddleName LastName:");
            String name=scn.nextLine();
            if (name.length() - name.replaceAll("\\s", "").length() - name.length() > 2 ||
                    name.replaceAll("\\s", "").length() < 4) {
                throw new InvalidNameExpressionException("Name should have Atleast 4 character");
            }
            for (int i = 0; i < name.length(); i++) {
                if (!Character.isAlphabetic(name.charAt(i))) {
                    throw new InvalidNameExpressionException("Character should be alphabets");
                }
            }
            return name.replaceAll("\\s","");
        }
        catch (InvalidNameExpressionException e)
        {
            System.out.println(e.getMessage());
            return validateName();
        }
    }
    public static LocalDate validateDateOfBirth()
    {

        try {
            System.out.println("Enter your Date Of Birth(dd-mm-yy)");
            String date=scn.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
            LocalDate ld = LocalDate.parse(date,formatter);
            LocalDate localDate = LocalDate.now().minusYears(18).plusDays(1);
            if(ld.isAfter(localDate)){
                throw new DateTimeException("You are age is below as per our policy requirement");
            }
            return ld;
        } catch ( Exception e ) {
            System.out.println("Please Enter a valid Date of Birth");
            return validateDateOfBirth();
        }
    }
    public static String validateAdharNumber()
    {
        try {
            System.out.println("Enter your AdharNumber:");
            String adharNumber = scn.nextLine();
            if (adharNumber.length() < 12 && adharNumber.length()>12) {
                throw new NumberFormatException("AdharNumber should be length of 12");
            }
            for (int i = 0; i < adharNumber.length(); i++) {
                if (!Character.isDigit(adharNumber.charAt(i))) {
                    throw new NumberFormatException("Character should be digit");
                }
            }
            if(adharNumber.charAt(0)=='0')
            {
                throw  new NumberFormatException("Invalid AdharNumber!");
                }
            return adharNumber;
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return validateAdharNumber();
        }
    }
}
