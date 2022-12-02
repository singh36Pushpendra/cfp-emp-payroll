package com.app.emppayroll.model;

import java.time.LocalDate;

public class Employee {
    private int empId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;

    public Employee(int empId, String name, long salary, String gender, LocalDate startDate, String note, String profilePic) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
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

    public int getEmpId() {
        return empId;
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