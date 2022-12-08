package com.app.emppayroll.repository;

import com.app.emppayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEmpRepo extends JpaRepository<Employee, Integer> {
    @Query(value = "select * from emp_payroll, emp_dept where emp_id = id and department = :department", nativeQuery = true)
    List<Employee> findEmpByDepartment(String department);
}
