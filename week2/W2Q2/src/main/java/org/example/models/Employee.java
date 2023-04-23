package org.example.models;

import java.time.LocalDate;

public class Employee {
    private String empId;
    private String empName;
    private LocalDate dateOfJoining;
    private String employType;
    private String role;
    private String domain;

    public Employee(String empId, String empName, LocalDate dateOfJoining, String employType, String role, String domain) {
        this.empId = empId;
        this.empName = empName;
        this.dateOfJoining = dateOfJoining;
        this.employType = employType;
        this.role = role;
        this.domain = domain;
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public String getEmployType() {
        return employType;
    }

    public String getRole() {
        return role;
    }

    public String getDomain() {
        return domain;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public void setEmployType(String employType) {
        this.employType = employType;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
