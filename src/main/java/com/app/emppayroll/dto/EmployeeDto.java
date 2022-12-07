package com.app.emppayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

// Using lombok generating parameterized constructor.
@AllArgsConstructor
public class EmployeeDto {

    // Validating employee name using annotations.
    @NotEmpty(message = "Employee name can't be null or empty!")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "Invalid employee name!")
    public String name;

    @Min(value = 10000, message = "Employee salary should be atleast 10,000Rs.!")
    public long salary;

    @Pattern(regexp = "male|female", message = "Employee should be either male or female!")
    public String gender;

    public LocalDate startDate;

    public String note;

    public String profilePic;

}
