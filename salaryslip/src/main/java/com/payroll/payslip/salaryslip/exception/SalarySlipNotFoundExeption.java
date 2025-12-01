package com.payroll.payslip.salaryslip.exception;

import java.util.function.Supplier;

public class SalarySlipNotFoundExeption extends RuntimeException {
    public SalarySlipNotFoundExeption(String message) {
        super(message);
    }

    public static Supplier<SalarySlipNotFoundExeption> supplier(String message) {
        return () -> new SalarySlipNotFoundExeption(message);
    }
}
