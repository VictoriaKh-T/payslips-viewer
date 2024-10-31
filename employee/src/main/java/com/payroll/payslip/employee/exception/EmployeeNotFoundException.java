package com.payroll.payslip.employee.exception;

import java.util.function.Supplier;

public class EmployeeNotFoundException extends RuntimeException {
  public EmployeeNotFoundException(String message) {
    super(message);
  }

  public static Supplier<EmployeeNotFoundException> supplier(String message) {
    return () -> new EmployeeNotFoundException(message);
  }
}
