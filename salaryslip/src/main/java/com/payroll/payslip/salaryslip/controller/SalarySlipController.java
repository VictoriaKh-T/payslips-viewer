package com.payroll.payslip.salaryslip.controller;

import com.payroll.payslip.salaryslip.model.dto.PayslipJsonDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/payslips")
public class SalarySlipController {

    @PostMapping("/upload")
    public String upload(@RequestBody PayslipJsonDTO dto) {
        return "OK";
    }

    @PostMapping("/view")
    public String viewPayslip(@RequestBody PayslipJsonDTO dto, Model model) {
        model.addAttribute("payslip", dto);
        return "payslipstemplate";
    }

}
