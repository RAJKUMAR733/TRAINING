package org.example.service;

import org.example.model.Employee;
import org.example.model.EmployementType;
import org.example.model.Status;

import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class EmployeeService {
    private static ArrayList<Employee> employeeList;
    public EmployeeService(ArrayList<Employee>employeeList)
    {
        this.employeeList=employeeList;
    }
    public static boolean addEmployee(Employee employee)
    {
        if(employeeList.add(employee))
            return true;
        return false;
    }
    public static boolean deleteEmployee(String empId)
    {
        for(Employee e:employeeList)
        {
            if(e.getEmpId().equalsIgnoreCase(empId))
            {
                e.setStatus(Status.DISSMISSED);
                return true;
            }
        }
        return false;
    }
    public static boolean updateEmployementType(String empId, String empType)
    {
        for(Employee emp:employeeList)
        {
            if(emp.getEmpId().equalsIgnoreCase(empId))
            {
                if(empType.equalsIgnoreCase(EmployementType.FULLTIME.toString()))
                {
                    emp.setEmploymentType(EmployementType.FULLTIME);
                    return true;
                }
                if(empType.equalsIgnoreCase(EmployementType.CONTRACT.toString()))
                {
                    emp.setEmploymentType(EmployementType.CONTRACT);
                    return true;
                }
             return true;
            }
        }
        return false;
    }
    public static boolean updateRoleType(String empId, String role){
        for(Employee emp:employeeList)
        {
            if(emp.getEmpId().equalsIgnoreCase(empId))
            {
                emp.setRole(role);
                return true;
            }

        }
        return false;
    }

    public static ArrayList<Employee> getSenior()
    {
        ArrayList<Employee>seniorEmployee=new ArrayList<>();
        LocalDate minimumDate=LocalDate.now().minusYears(10);
        for(Employee emp:employeeList)
        {
            if(emp.getDateOfJoining().isBefore(minimumDate)&&!emp.getStatus().equals(Status.DISSMISSED))
            {
                seniorEmployee.add(emp);
            }

        }
        return seniorEmployee;
    }
    public static ArrayList<Employee>getEmployeeForStatus(String status)
    {
        ArrayList<Employee>al=new ArrayList<>();
        for(Employee emp:employeeList)
        {
            if(status.equalsIgnoreCase(emp.getStatus().toString()))
            {
                al.add(emp);
            }
        }
        return al;
    }
    public static void inputAddingDetails(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter Employee Details:");
        System.out.println("Enter name:");
        String name=scn.nextLine();
        System.out.println("Enter Employetype(contract/fulltime):");
        String employeType=scn.nextLine();
        EmployementType employementType=null;
        if(employeType.equalsIgnoreCase("Contract"))
            employementType=EmployementType.CONTRACT;
        if(employeType.equalsIgnoreCase("fulltime"))
            employementType=EmployementType.FULLTIME;
        System.out.println(employeType);
        if(employementType==null)
        {
            System.out.println("Enter Valid EmployeType");
            takeInput();
        }
        System.out.println("Enter role:");
        String role=scn.nextLine();
//        System.out.println(new Employee(GenerateUniqueId.generateUniqueId(LocalDate.now()),name,
//                employementType,role,Status.ACTIVE,LocalDate.now()));
        if(addEmployee(new Employee(GenerateUniqueId.generateUniqueId(LocalDate.now()),name,
                employementType,role,Status.ACTIVE,LocalDate.now()))) {
            System.out.println("Employee is added to Database!");
            takeInput();
        }
        else {
            System.out.println("Error occurred!");
            inputAddingDetails();
        }

        }
    public static void inputDeletingDetails()
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter uid:");
        String uid=scn.nextLine();
        if(deleteEmployee(uid)){
            System.out.println("Employee is deleted!");
        }
        else {
            System.out.println("Error Occurred!");
            inputDeletingDetails();
        }

    }
    public static void inputUpdatingEmployementType()
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter uid:");
        String uid=scn.nextLine();
        System.out.println("Enter EmploymentType:");
        String employementType=scn.nextLine();
        if(updateEmployementType(uid,employementType))
        {
            System.out.println("Updated!");
            takeInput();
        }
        else {
            System.out.println("Error Occurred!");
            inputUpdatingEmployementType();
        }
    }
    public static void takeInput(){
        Scanner scn=new Scanner(System.in);
        System.out.println("Welcome! Choose Any Operation:");
        System.out.println("Enter 1 for adding employee : ");
        System.out.println("Enter 2 for deleting employee : ");
        System.out.println("Enter 3 for updating employement type : ");
        System.out.println("Enter 4 for updating role : ");
        System.out.println("Enter 5 for getting most experience employees : ");
        System.out.println("Enter 6 for print all data : ");
        System.out.println("Enter 7 for start again : ");
        System.out.println("Enter 8 for exit : ");

        int n =scn.nextInt();

        switch (n)
        {
            case 1:
                inputAddingDetails();
                break;

            case 2:
                inputDeletingDetails();
            case 3:
                inputUpdatingEmployementType();
            case 4:
                inputUpdatingrole();
            case 5:
                inputGetingSenior();
            case 6:
                printingDetails();
            case 7:
                inputEmployeForStatus();
            case 8:
                break;
            default:
                takeInput();

        }

    }
    public static void inputEmployeForStatus()
    {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter status");
        String status= scn.nextLine();
        if(getEmployeeForStatus(status).size()==0)
        {
            System.out.println("No Employee for this status!");
            takeInput();
        }
        for(Employee emp:getEmployeeForStatus(status))
        {
            System.out.println(emp);
        }
        takeInput();
    }
    public static void printingDetails()
    {
        for(Employee emp:employeeList)
        {
            if(emp.getStatus()==Status.ACTIVE)
            {
                System.out.println(emp);

            }
        }
        takeInput();
    }
    public static void inputGetingSenior()
    {
        if(getSenior().size()==0)
        {
            System.out.println("No Senior Employee is available At this moment!");
        }
        for(Employee emp:getSenior())
        {
            System.out.println(emp);
        }
        takeInput();
    }
    private static void inputUpdatingrole() {
        Scanner scn=new Scanner(System.in);
        System.out.println("Enter uid:");
        String uid=scn.nextLine();
        System.out.println("Enter role:");
        String role=scn.nextLine();
        if(updateRoleType(uid,role))
        {
            System.out.println("Updated!");
        }
        else {
            System.out.println("Error Occured!");
            inputUpdatingrole();
        }
    }


}
