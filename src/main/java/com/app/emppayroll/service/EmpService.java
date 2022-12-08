package com.app.emppayroll.service;

import com.app.emppayroll.dto.EmployeeDto;
import com.app.emppayroll.exception.EmpPayrollException;
import com.app.emppayroll.model.Employee;
import com.app.emppayroll.repository.IEmpRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Marking a class to provide service.
@Service
@Slf4j
public class EmpService implements IEmpService {

    // Used for automatic dependency injection.
    @Autowired
    private IEmpRepo repo;

    // Saving employee in repo.
    public Employee insertEmp(EmployeeDto empDto) {
        log.info("Executing insertEmp() method body in service layer!");

        Employee employee = new Employee(empDto);
        return repo.save(employee);
    }

    // Updating employee in repo.
    public Employee updateEmp(int id, EmployeeDto empDto) {
        // Finding an employee by its id and saving to a container object.
        Optional<Employee> optionalEmployee = repo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee emp = new Employee(empDto);
            emp.setEmpId(id);
            return repo.save(emp);
        }
        throw new EmpPayrollException("Can't update employee details id = '" + id + "' not exists!");
    }

    // Getting employee info from repo.
    public Employee selectEmp(int id) {
        Optional<Employee> optionalEmployee = repo.findById(id);

        // Throwing custom exception.
        if (! optionalEmployee.isPresent())
            throw new EmpPayrollException("Employee for id = '" + id + "' not exists!");

        return optionalEmployee.get();
    }

    // Deleting employee info from repo.
    public Employee deleteEmp(int id) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        if (! optionalEmployee.isPresent())
            throw new EmpPayrollException("Can't delete id = '" + id + "' not exists!");
        repo.deleteById(id);
        return optionalEmployee.get();
    }

    // Getting all employee info from repo.
    public List<Employee> selectAllEmp() {
        return repo.findAll();
    }
}