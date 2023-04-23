package org.example;

import org.example.models.Employee;
import org.example.service.FileHandlingService;
import org.example.service.FileReader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Employee>empList=FileReader.fileReader("myfile.text");
//        FileHandlingService.displayEmployeDetils("001",empList);
//        FileHandlingService.displayEmployeGivenRole("tester",empList);
        FileHandlingService.displayEmployeeforGivenExperience(20,empList);

    }
}