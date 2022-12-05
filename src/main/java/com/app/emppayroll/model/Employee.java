package com.app.emppayroll.model;

import com.app.emppayroll.dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

// To map class into relation(table).
@Entity

// Using lombok library to generate boiler plate for setter, getter and zeroth arg constructor.
@Setter
@Getter
@NoArgsConstructor
public class Employee {

    // To define primary key for relation.
    @Id
    // To increment id value automatically.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    // Using EmployeeDto object
    public Employee(EmployeeDto employeeDto) {
        name = employeeDto.name;
        salary = employeeDto.salary;
        gender = employeeDto.gender;
        startDate = employeeDto.startDate;
        note = employeeDto.note;
        profilePic = employeeDto.profilePic;
    }
}