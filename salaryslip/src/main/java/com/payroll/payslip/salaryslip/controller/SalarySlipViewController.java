package com.payroll.payslip.salaryslip.controller;

import com.payroll.payslip.salaryslip.model.MonthOfYear;
import com.payroll.payslip.salaryslip.model.dto.SalarySlipResponse;
import com.payroll.payslip.salaryslip.service.SalarySlipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payslips/view")
public class SalarySlipViewController {
    private final SalarySlipService salarySlipService;

    public SalarySlipViewController(SalarySlipService salarySlipService) {
        this.salarySlipService = salarySlipService;
    }

    @GetMapping("/{employeeId}")
    public String viewPayslip(
            @PathVariable Long employeeId,
            @RequestParam("year") int year,
            @RequestParam("month") MonthOfYear month,
            Model model) {
        SalarySlipResponse slip = salarySlipService.findByEmployeeIdAndYearAndMonthOfYear(employeeId, year, month);
        model.addAttribute("payslip", slip);
        return "payslip";
    }
}
