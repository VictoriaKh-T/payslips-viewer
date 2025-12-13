package com.payroll.payslip.salaryslip.grpc.server;

import com.payroll.payslip.proto.SalarySlipDataServiceGrpc;
import com.payroll.payslip.salaryslip.service.SalarySlipService;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class SalarySlipGrpcServiceImpl extends SalarySlipDataServiceGrpc.SalarySlipDataServiceImplBase {
    private final SalarySlipService salarySlipService;

    public SalarySlipGrpcServiceImpl(SalarySlipService salarySlipService) {
        this.salarySlipService = salarySlipService;
    }
}
