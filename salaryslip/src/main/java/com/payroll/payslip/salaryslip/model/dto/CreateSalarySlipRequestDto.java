package com.payroll.payslip.salaryslip.model.dto;

import java.util.Map;
import lombok.Data;

@Data
public class CreateSalarySlipRequestDto {
    private Long employeeId;
    private String employeeName;
    private String monthOfYear;
    private int year;

    private Double baseSalary;
    private Double tax;
    private Double netSalary;

    private Integer hoursWorked;
    private Double hourRate;
    private Map<String, Double> extras;
}
