package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetSalarySlipRequest;
import com.payroll.payslip.proto.GetSalarySlipResponse;
import com.payroll.payslip.proto.SalarySlipDataServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SalarySlipGrpcClient {

    private final SalarySlipDataServiceGrpc.SalarySlipDataServiceBlockingStub salarySlipStub;

    public SalarySlipGrpcClient(@Qualifier("salarySlipChannel") ManagedChannel salarySlipChannel) {
        this.salarySlipStub = SalarySlipDataServiceGrpc.newBlockingStub(salarySlipChannel);
    }

    public GetSalarySlipResponse getSalarySlipById(int id) {
        GetSalarySlipRequest request =
                GetSalarySlipRequest.newBuilder().setId(id).build();
        return salarySlipStub.getSalarySlipById(request);
    }
}
