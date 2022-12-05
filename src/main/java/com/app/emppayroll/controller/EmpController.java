package com.app.emppayroll.controller;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.dto.ResponseDto;
import com.app.emppayroll.model.Employee;
import com.app.emppayroll.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<ResponseDto> postEmp(@RequestBody EmployeeDto employeeDto) {
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
    public ResponseEntity<ResponseDto> putEmp(@RequestParam int id, @RequestBody EmployeeDto employeeDto) {
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
}
