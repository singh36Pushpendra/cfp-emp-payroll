package com.app.emppayroll.dto;

import java.time.LocalDate;

public class EmployeeDto {
    public String name;
    public long salary;
    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;

    public EmployeeDto(String name, long salary, String gender, LocalDate startDate, String note, String profilePic) {
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
    }

}
