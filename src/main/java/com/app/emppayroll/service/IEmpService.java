package com.app.emppayroll.service;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.model.Employee;

// Creating an interface for security(abstraction) purpose.
public interface IEmpService {
    Employee insertEmp(EmployeeDto employeeDto);
    Employee updateEmp(int id, EmployeeDto employeeDto);
    Employee selectEmp(int id);
    void deleteEmp(int id);
}
