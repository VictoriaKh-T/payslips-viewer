package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record CreateEmployeeRequestDto(
    Long personId, Long organizationId, LocalDate emplDate, LocalDate disDate) {}
