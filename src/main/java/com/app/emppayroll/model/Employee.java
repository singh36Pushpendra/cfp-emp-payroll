package com.app.emppayroll.model;

import com.app.emppayroll.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDate;
import java.util.List;

// To map class into relation(table).
@Entity
@Table(name = "emp_payroll")
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
    // Setting name of variable empId in a table.
    @Column(name = "emp_id")
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    // To persist the collection in a separate table without using entity class.
    @ElementCollection
    // Used to refer the collection table name and a join column which refers primary table.
    @CollectionTable(name = "emp_dept", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "department")
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