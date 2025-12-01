package com.payroll.payslip.salaryslip.model.dto;

public record CreateSalarySlipRequest(Long id, Long employee_id, String monthOfYear, int year, String filePath) {}
