package com.app.emppayroll.model;

import com.app.emppayroll.dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

// To map class into relation(table).
@Entity

// Using lombok library to generate boiler plate for getter and zeroth arg constructor.
@Getter
@NoArgsConstructor
@Slf4j
public class Employee {

    // To define primary key for relation.
    @Id
    // To increment id value automatically.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Just to add setter for empId instance variable.
    @Setter
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    private List<String> departments;

    // Using EmployeeDto object
    public Employee(EmployeeDto employeeDto) {
        log.info("Inside Employee class constructor!");

        name = employeeDto.name;
        salary = employeeDto.salary;
        gender = employeeDto.gender;
        startDate = employeeDto.startDate;
        note = employeeDto.note;
        profilePic = employeeDto.profilePic;
        departments = employeeDto.departments;
    }
}