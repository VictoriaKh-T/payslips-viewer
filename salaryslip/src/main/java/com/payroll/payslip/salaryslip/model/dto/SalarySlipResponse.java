package com.payroll.payslip.salaryslip.model.dto;

public record SalarySlipResponse(Long id, Long employee_id, String period, int year, String filePath) {}
