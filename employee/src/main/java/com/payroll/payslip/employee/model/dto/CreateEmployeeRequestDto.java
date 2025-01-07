package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record CreateEmployeeRequestDto(
        String fullName, LocalDate employmentDate, LocalDate dismissDate, Long personId, Long organizationId) {}
