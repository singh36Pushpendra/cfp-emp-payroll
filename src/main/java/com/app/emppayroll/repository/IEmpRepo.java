package com.app.emppayroll.repository;

import com.app.emppayroll.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpRepo extends JpaRepository<Employee, Integer> {
}
