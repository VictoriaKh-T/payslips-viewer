package com.payroll.payslip.salaryslip.service;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public interface SalarySlipService {
    List<SalarySlipResponse> findAll();

    List<SalarySlipResponse> findByEmployeeId(Long employeeId);

    List<SalarySlipResponse> findByYearAndMonth(int year, MonthOfYear monthOfYear);

    void uploadZipFile(MultipartFile file) throws IOException;

    SalarySlipResponse findByEmployeeIdAndYearAndMonthOfYear(Long employeeId, int year, MonthOfYear monthOfYear);
}
