package com.payroll.payslip.organization.model.dto;

public record UpdateOrganizationResponse(
        Long id, String kodOrganization, String name, String telephoneNumber, String address) {}
