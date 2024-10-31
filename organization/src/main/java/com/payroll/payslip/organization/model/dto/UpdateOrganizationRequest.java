package com.payroll.payslip.organization.model.dto;

public record UpdateOrganizationRequest(
    String kodOrganization, String name, String telephoneNumber, String address) {}
