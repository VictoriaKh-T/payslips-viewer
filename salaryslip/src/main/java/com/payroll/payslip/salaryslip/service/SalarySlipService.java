package com.payroll.payslip.salaryslip.service;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.dto.CreateSalarySlipRequest;
import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import java.util.List;

public interface SalarySlipService {
    List<SalarySlipResponse> findAll();

    SalarySlipResponse create(CreateSalarySlipRequest request);

    List<SalarySlipResponse> findByEmployeeId(Long employeeId);

    List<SalarySlipResponse> findByYearAndMonth(int year, MonthOfYear monthOfYear);
}
