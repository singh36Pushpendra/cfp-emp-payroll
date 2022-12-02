package com.app.emppayroll.model;

import com.app.emppayroll.dto.EmployeeDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

// To map class into relation(table).
@Entity
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

    public Employee() {
    }

    // Using EmployeeDto object
    public Employee(EmployeeDto employeeDto) {
        name = employeeDto.name;
        salary = employeeDto.salary;
        gender = employeeDto.gender;
        startDate = employeeDto.startDate;
        note = employeeDto.note;
        profilePic = employeeDto.profilePic;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getName() {
        return name;
    }

    public long getSalary() {
        return salary;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getNote() {
        return note;
    }

    public String getProfilePic() {
        return profilePic;
    }
}