package com.payroll.payslip.organization.model.dto;

public record OrganizationResponse(
    Long id, String kodOrganization, String name, String telephoneNumber, String address) {}
