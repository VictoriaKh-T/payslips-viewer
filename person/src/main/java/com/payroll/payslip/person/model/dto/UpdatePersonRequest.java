package com.payroll.payslip.person.model.dto;

import java.time.LocalDate;

public record UpdatePersonRequest(
        String email, String firstName, String secondName, String surname, LocalDate birthDate) {}
