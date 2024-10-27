package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record DismissEmployeeResponse(Long id, String fullName, LocalDate dismissDate) {}
