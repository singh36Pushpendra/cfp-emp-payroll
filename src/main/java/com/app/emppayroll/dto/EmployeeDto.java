package com.app.emppayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

// Using lombok generating parameterized constructor.
@AllArgsConstructor
public class EmployeeDto {

    // Validating employee name using annotations.
    @NotEmpty(message = "Employee name can't be null or empty!")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Invalid employee name!")
    public String name;

    @Min(value = 10000, message = "Employee salary should be atleast 10,000Rs.!")
    public long salary;

    @Pattern(regexp = "male|female", message = "Employee should be either male or female!")
    public String gender;

    // Defining the format for date value for json.
    @JsonFormat(pattern = "dd MMM yyyy")
    @NotNull(message = "Start Date should not be empty!")
    @PastOrPresent(message = "Start Date should be either past or todays!")
    public LocalDate startDate;

    @NotBlank(message = "Note value can't be empty!")
    public String note;

    @NotBlank(message = "Profile picture can't be empty!")
    public String profilePic;

    @NotNull(message = "Departments should not be empty!")
    public List<String> departments;

}