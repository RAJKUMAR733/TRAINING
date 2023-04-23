package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

    private String empId;

    private String empName;
    private EmployementType employmentType;
    private String role;
    private Status status;
    private LocalDate dateOfJoining;

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", employmentType=" + employmentType +
                ", role='" + role + '\'' +
                ", status=" + status +
                ", dateOfJoining=" + dateOfJoining +
                '}';
    }
}
