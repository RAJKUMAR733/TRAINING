package org.example.service;

import org.example.models.Employee;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class FileReader {
    private static ArrayList<Employee>employeeList;

    public static ArrayList<Employee>fileReader(String fileName)
    {
        employeeList=new ArrayList<>();
        try{
            File file=new File(fileName);
            Scanner reader=new Scanner(file);
            while(reader.hasNextLine())
            {
                String str=reader.nextLine();
//                System.out.println(str);
                String[]employeeData=str.split(";");
//                Arrays.stream(employeeData).forEach((stri)->System.out.println(stri));
                DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate dateOfJoining=LocalDate.parse(employeeData[2],dateTimeFormatter);
                Employee e=new Employee(employeeData[0],employeeData[1],dateOfJoining,
                        employeeData[3],employeeData[4],employeeData[5] );
                employeeList.add(e);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File is not present!");
        }
        catch (IOException e)
        {
            System.out.println("File is not in format!");
        }
        return employeeList;

    }
}
