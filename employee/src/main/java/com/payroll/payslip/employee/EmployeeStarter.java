package com.payroll.payslip.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.payroll.payslip")
public class EmployeeStarter {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeStarter.class, args);
    }
}
