package com.payroll.payslip.department.exception;

import java.util.function.Supplier;

public class DepartmentNotFoundException extends RuntimeException {
    public DepartmentNotFoundException(String message) {
        super(message);
    }

    public static Supplier<DepartmentNotFoundException> supplier(String message) {
        return () -> new DepartmentNotFoundException(message);
    }
}
