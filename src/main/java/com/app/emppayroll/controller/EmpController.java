package com.app.emppayroll.controller;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.dto.ResponseDto;
import com.app.emppayroll.model.Employee;
import com.app.emppayroll.service.IEmpService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// Providing ability to handle client requests.
@RestController
@RequestMapping(value = {"/emp", "/employee"})
// In order to use log.info() we need to add bellow annotation.
@Slf4j
public class EmpController {

    @Autowired // Automatic Dependency Injection.
    private IEmpService service;

    private List<Employee> employees = new ArrayList<>();

    // Api to handle client's posting.
    @PostMapping("/post")
    // Telling spring to evaluate constraint annotations on method parameter
    public ResponseEntity<ResponseDto> postEmp(@Valid @RequestBody EmployeeDto employeeDto) {
        // To print something on console.
        log.info("Executing postEmp() method body!");

        Employee employee = service.insertEmp(employeeDto);
        employees.add(employee);

        // To return message and object both together we use ResponseDto.
        ResponseDto responseDto = new ResponseDto("You are registered successfully!", employee);

        // Represents the whole Http response.
        // Used to configure Http response.
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    // Api to handle client's editing
    @PutMapping("/put")
    public ResponseEntity<ResponseDto> putEmp(@RequestParam int id, @Valid @RequestBody EmployeeDto employeeDto) {
        Employee employee = service.updateEmp(id, employeeDto);
        employees.add(employee);

        ResponseDto responseDto = new ResponseDto("Your profile updated succesfully!", employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    // Api to retrieve client's info.
    @GetMapping("/get")
    public ResponseEntity<ResponseDto> getEmp(@RequestParam int id) {
        Employee employee = service.selectEmp(id);
        ResponseDto responseDto = new ResponseDto("Your Profile: ", employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    // Api to delete client's info.
    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEmp(@RequestParam int id) {
        Employee employee = service.deleteEmp(id);
        employees.add(employee);

        ResponseDto responseDto = new ResponseDto("Your profile deleted successfully!", employee);
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);
        return response;
    }

    // Api to view all emp info.
    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> getAllEmp() {
        ResponseDto responseDto = new ResponseDto("Profile of all Employees: ", service.selectAllEmp());
        ResponseEntity<ResponseDto> response = new ResponseEntity<>(responseDto, HttpStatus.OK);

        return response;
    }

    // Defining api to get employee by department.
    @GetMapping("/getbydept/{department}")
    public ResponseEntity<ResponseDto> getEmpsByDept(@PathVariable String department) {
        ResponseDto responseDto = new ResponseDto("Profiles of employees which have " + department + " department!", service.getEmpsByDepartment(department));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }
}