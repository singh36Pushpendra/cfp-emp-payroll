package com.app.emppayroll.controller;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.model.Employee;
import com.app.emppayroll.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Providing ability to handle client requests.
@RestController
@RequestMapping(value = {"/emp", "/employee"})
public class EmpController {

    @Autowired // Automatic Dependency Injection.
    private IEmpService service;

    // Api to handle client's posting.
    @PostMapping("/post")
    public Employee postEmp(@RequestBody EmployeeDto employeeDto) {
        return service.insertEmp(employeeDto);
    }

    // Api to handle client's editing
    @PutMapping("/put")
    public Employee putEmp(@RequestParam int id, @RequestBody EmployeeDto employeeDto) {
        return service.updateEmp(id, employeeDto);
    }

    // Api to retrieve client's info.
    @GetMapping("/get")
    public Employee getEmp(@RequestParam int id) {
        return service.selectEmp(id);
    }

    // Api to delete client's info.
    @DeleteMapping("/delete")
    public String deleteEmp(@RequestParam int id) {
        service.deleteEmp(id);
        return "Employee '" + id + "' deleted successfully!";
    }
}