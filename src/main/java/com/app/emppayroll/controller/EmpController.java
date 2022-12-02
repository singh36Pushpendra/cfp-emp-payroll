package com.app.emppayroll.controller;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.model.Employee;
import com.app.emppayroll.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Providing ability to handle client requests.
@RestController
@RequestMapping(value = {"/emp", "/employee"})
public class EmpController {

    @Autowired // Automatic Dependency Injection.
    private IEmpService service;

    private List<Employee> employees = new ArrayList<>();

    // Api to handle client's posting.
    @PostMapping("/post")
    public Employee postEmp(@RequestBody EmployeeDto employeeDto) {
        employees.add(new Employee(employeeDto));
        return service.insertEmp(employeeDto);
    }

    // Api to handle client's editing
    @PutMapping("/put")
    public Employee putEmp(@RequestParam int id, @RequestBody EmployeeDto employeeDto) {
        employees.add(new Employee(employeeDto));
        return service.updateEmp(id, employeeDto);
    }

    // Api to retrieve client's info.
    @GetMapping("/get")
    public Employee getEmp(@RequestParam int id) {
        return service.selectEmp(id);
    }

    // Api to delete client's info.
    @DeleteMapping("/delete")
    public Employee deleteEmp(@RequestParam int id) {
        Employee employee = service.deleteEmp(id);
        employees.add(employee);
        return employee;
    }

    // Api to view all emp info.
    @GetMapping("/getall")
    public List<Employee> getAllEmp() {
        return service.selectAllEmp();
    }
}