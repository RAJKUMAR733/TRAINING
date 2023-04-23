package org.example;

import org.example.model.Employee;
import org.example.model.EmployementType;
import org.example.model.Status;
import org.example.service.EmployeeService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EmployeeService employeeService=new EmployeeService(new ArrayList<>());
        try{
            employeeService.takeInput();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            employeeService.takeInput();
        }



    }
}