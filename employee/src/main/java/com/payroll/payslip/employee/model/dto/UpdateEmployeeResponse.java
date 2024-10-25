package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record UpdateEmployeeResponse(
    Long employeeId,
    String fullName,
    LocalDate emplDate,
    LocalDate disDate,
    Long personId,
    Long organizationId) {}
