package org.example.service;

import org.example.models.Employee;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileHandlingService {
    public static void displayEmployeDetils(String empId, ArrayList<Employee>employeeArrayList)
    {
        for(Employee emp:employeeArrayList)
        {
            if(emp.getEmpId().equalsIgnoreCase(empId)){
                System.out.println("EmployeeID:"+empId+",EmployeeName:"+emp.getEmpName()+
                ",DateOfJoining:"+emp.getDateOfJoining()+",EmploymentType:"+emp.getEmployType()+
                        ",Role:"+emp.getRole()+",Domain:"+emp.getDomain());
                return;
            }
        }
        System.out.println("Error Occurred!");
    }
    public static void displayEmployeGivenRole(String role, ArrayList<Employee>employeeArrayList)
    {
        ArrayList<Employee>requiredList=new ArrayList<>();
        for(Employee emp:employeeArrayList)
        {
            if(emp.getRole().equalsIgnoreCase(role))
            {
                requiredList.add(emp);
            }
        }
        if(requiredList.size()==0){
            System.out.println("No Employee for this role!");
            return;
        }
        requiredList.forEach((emp)->System.out.println("EmployeeID:"+emp.getEmpId()+",EmployeeName:"+emp.getEmpName()+
                ",DateOfJoining:"+emp.getDateOfJoining()+",EmploymentType:"+emp.getEmployType()+
                ",Role:"+emp.getRole()+",Domain:"+emp.getDomain()));

    }
    public static void displayEmployeeforGivenExperience(int minimumExp,ArrayList<Employee>employeeArrayList)
    {
        ArrayList<Employee>requiredList=new ArrayList<>();
        for (Employee emp:employeeArrayList)
        {
            int exp=LocalDate.now().getYear()-emp.getDateOfJoining().getYear();
            if(exp>=minimumExp)
            {
                requiredList.add(emp);
            }
        }
        if(requiredList.size()==0)
        {
            System.out.println("No employee with this minimum Experience!");
            return;
        }
        requiredList.forEach((emp)->System.out.println("EmployeeID:"+emp.getEmpId()+",EmployeeName:"+emp.getEmpName()+
                ",DateOfJoining:"+emp.getDateOfJoining()+",EmploymentType:"+emp.getEmployType()+
                ",Role:"+emp.getRole()+",Domain:"+emp.getDomain()));
    }
}
