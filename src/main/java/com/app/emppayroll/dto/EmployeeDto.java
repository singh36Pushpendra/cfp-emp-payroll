package com.app.emppayroll.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;

// Using lombok generating parameterized constructor.
@AllArgsConstructor
public class EmployeeDto {
    public String name;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

}
