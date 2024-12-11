package com.payroll.payslip.person.model.dto;

import java.time.LocalDate;

public record UpdatePersonResponse(
    Long id,
    String email,
    String firstName,
    String secondName,
    String surname,
    LocalDate birthDate) {}
