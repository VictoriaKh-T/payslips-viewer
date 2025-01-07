package com.payroll.payslip.organization.exception;

import java.util.function.Supplier;

public class OrganizationNotFoundException extends RuntimeException {
    public OrganizationNotFoundException(String message) {
        super(message);
    }

    public static Supplier<OrganizationNotFoundException> supplier(String message) {
        return () -> new OrganizationNotFoundException(message);
    }
}
