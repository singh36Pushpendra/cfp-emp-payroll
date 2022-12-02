package com.app.emppayroll.controller;

import com.app.emppayroll.model.Employee;
import org.springframework.web.bind.annotation.*;

// Providing ability to handle client requests
@RestController
@RequestMapping("/emp")
public class EmpController {

    // Api to handle client's posting.
    @PostMapping("/post")
    public Employee postEmp(@RequestBody Employee employee) {
        return employee;
    }

    // Api to handle client's editing
    @PutMapping("/put")
    public Employee putEmp(@RequestParam int id, @RequestBody Employee employee) {
        employee.setEmpId(id);
        return employee;
    }

    ZZ
    // Api to retrieve client's info.
    @GetMapping("/get")
    public String getEmp(@RequestParam int id) {
        return "Employee Profile!";
    }

    // Api to delete client's info.
    @DeleteMapping("/delete")
    public String deleteEmp(@RequestParam int id) {
        return "Employee Deletion!";
    }
}