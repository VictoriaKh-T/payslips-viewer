package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record DismissEmployeeRequest(Long id, String fullName, LocalDate dismissDate) {}
