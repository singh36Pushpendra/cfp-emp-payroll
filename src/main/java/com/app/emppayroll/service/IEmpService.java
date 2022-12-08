package com.app.emppayroll.service;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.model.Employee;

import java.util.List;

// Creating an interface for security(abstraction) purpose.
public interface IEmpService {
    Employee insertEmp(EmployeeDto employeeDto);
    Employee updateEmp(int id, EmployeeDto employeeDto);
    Employee selectEmp(int id);
    Employee deleteEmp(int id);
    List<Employee> selectAllEmp();
    List<Employee> getEmpsByDepartment(String dept);
}
