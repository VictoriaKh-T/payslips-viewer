package com.payroll.payslip.salaryslip.model.dto;

import lombok.Data;

import java.util.Map;

@Data
public class PayslipJsonDTO {
    private Long employeeId;
    private String employeeName;
    private String period;

    private Double baseSalary;
    private Double tax;
    private Double netSalary;

    private Integer hoursWorked;
    private Double hourRate;
    private Map<String, Double> extras;

}
