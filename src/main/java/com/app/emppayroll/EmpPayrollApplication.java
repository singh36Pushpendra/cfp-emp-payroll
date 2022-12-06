package com.app.emppayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class EmpPayrollApplication {

    public static void main(String[] args) {
        // Used to print over the console.
        log.info("Before starting Spring Boot application!");
        SpringApplication.run(EmpPayrollApplication.class, args);
        log.info("After starting Spring Boot application!");
    }

}
