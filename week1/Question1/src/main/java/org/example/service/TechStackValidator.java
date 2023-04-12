package org.example.service;

import org.example.Exceptions.InvalidExperienceExpception;
import org.example.Exceptions.InvalidSalaryExpressionException;
import org.example.Exceptions.InvalidTechStackException;
import org.example.model.Openings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TechStackValidator {
    static Scanner scn = new Scanner(System.in);

    public static String techInput() {
        String userStack = scn.nextLine();
        return userStack;
    }

    public static void techValidator() {
        try {
            System.out.println("Enter TechStack:");
            String userTech = techInput();
            boolean checkStack = true;
            for (Openings openings : Openings.values()) {

                if (userTech.equalsIgnoreCase(openings.name())) {
                    checkStack = false;
                    int userExperience = experienceInput(openings.getExperience());
                    double userCurrentSalary =salaryInput();
                    System.out.println(SalaryCalculater.calculateSalary(openings,userExperience,userCurrentSalary));
                }
            }
            if (checkStack) {
                throw new InvalidTechStackException("Invalid TechStack! Please enter a valid techStack");

            }
        } catch (InvalidTechStackException e) {
            System.out.println(e.getMessage());
            techValidator();
        }
    }

    private static int experienceInput(int requiredExperince) {
        try {
            System.out.println("Enter Experience:");
            Pattern p = Pattern.compile("^[1-9][0-9]?$|^100$");
            String experience = scn.nextLine();
            int userExperience=0;
            Matcher matcher = p.matcher(experience);
            if(!matcher.matches()){
                throw new InvalidExperienceExpception("the number should be in between 1 to 100 and shouldn't contain special characters");
            }
            else {
                userExperience=Integer.parseInt(experience);
            }
            if (requiredExperince > userExperience) {
                throw new InvalidExperienceExpception("Invalid Experience");
            } else {
                return userExperience;
            }
        } catch (InvalidExperienceExpception e) {
            System.out.println(e.getMessage());
            return experienceInput(requiredExperince);
        }
    }
    private static double salaryInput()
    {
        try{
            System.out.println("Enter Current Salary:");
            Pattern pattern=Pattern.compile("^[1-9][0-9]?$|^100$");
            String Salary=scn.nextLine();
            Double currentSalary=0.0;
            Matcher matcher= pattern.matcher(Salary);
            if(!matcher.matches()){
                throw new InvalidSalaryExpressionException
                        ("Invalid Salry Expression! Please provide a proper Salary Expression");
            }
            else {
                currentSalary = Double.parseDouble(Salary);
                return currentSalary;
            }
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            return salaryInput();
        }

    }
}
