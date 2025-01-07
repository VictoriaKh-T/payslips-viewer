package com.payroll.payslip.employee.model.dto;

import java.time.LocalDate;

public record EmployeeResponse(
        Long id,
        String fullName,
        LocalDate employmentDate,
        LocalDate dismissDate,
        Long personId,
        Long organizationId) {}
