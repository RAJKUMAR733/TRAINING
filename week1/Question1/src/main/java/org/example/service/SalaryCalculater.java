package org.example.service;

import org.example.model.Openings;

public class SalaryCalculater {

    public static double calculateSalary(Openings post,int experience,double currentSalary){
        return currentSalary+(currentSalary*post.getRole().getIncrement())/(double)100;
    }
}
