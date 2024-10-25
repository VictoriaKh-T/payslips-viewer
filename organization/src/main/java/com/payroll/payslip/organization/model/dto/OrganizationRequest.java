package com.payroll.payslip.organization.model.dto;

public record OrganizationRequest(
    Long id, String kodOrganization, String name, String telephoneNumber, String address) {}
