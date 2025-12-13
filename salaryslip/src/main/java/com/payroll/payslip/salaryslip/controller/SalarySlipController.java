package com.payroll.payslip.salaryslip.controller;

import com.payroll.payslip.salaryslip.service.SalarySlipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Tag(name = "Payslips management", description = "Endpoints for managing payslips")
@RestController
@RequiredArgsConstructor
@RequestMapping("/payslips")
public class SalarySlipController {
    private final SalarySlipService salarySlipService;

    @PostMapping("/upload/batch")
    @ResponseStatus(HttpStatus.CREATED)
    public void upload(@RequestParam("file") MultipartFile file) throws IOException {
        salarySlipService.uploadZipFile(file);
    }
}
