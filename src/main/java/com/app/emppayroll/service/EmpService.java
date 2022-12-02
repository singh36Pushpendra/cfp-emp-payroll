package com.app.emppayroll.service;

import com.app.emppayroll.model.Employee;
import com.app.emppayroll.repository.IEmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Marking a class to provide service.
@Service
public class EmpService {

    // Used for automatic dependency injection.
    @Autowired
    IEmpRepo repo;

    // Saving employee in repo.
    public Employee insertEmp(Employee emp) {
        return repo.save(emp);
    }

    // Updating employee in repo.
    public Employee updateEmp(int id, Employee emp) {
        // Finding an employee by its id and saving to a container object.
        Optional<Employee> optionalEmployee = repo.findById(id);
        optionalEmployee.get().setName(emp.getName());
        optionalEmployee.get().setSalary(emp.getSalary());
        optionalEmployee.get().setGender(emp.getGender());
        optionalEmployee.get().setStartDate(emp.getStartDate());
        optionalEmployee.get().setNote(emp.getNote());
        optionalEmployee.get().setProfilePic(emp.getProfilePic());
        return repo.save(optionalEmployee.get());
    }

    // Getting employee info from repo.
    public Employee selectEmp(int id) {
        return repo.findById(id).get();
    }

    // Deleting employee info from repo.
    public void deleteEmp(int id) {
        repo.deleteById(id);
    }
}
