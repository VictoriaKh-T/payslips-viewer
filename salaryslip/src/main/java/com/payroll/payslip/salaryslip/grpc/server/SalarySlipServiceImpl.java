package com.payroll.payslip.salaryslip.grpc.server;

import com.payroll.payslip.proto.SalarySlipDataServiceGrpc;
import com.payroll.payslip.salaryslip.service.SalarySlipService;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SalarySlipServiceImpl extends SalarySlipDataServiceGrpc.SalarySlipDataServiceImplBase {
    private final SalarySlipService salarySlipService;

    public SalarySlipServiceImpl(SalarySlipService salarySlipService) {
        this.salarySlipService = salarySlipService;
    }
}
