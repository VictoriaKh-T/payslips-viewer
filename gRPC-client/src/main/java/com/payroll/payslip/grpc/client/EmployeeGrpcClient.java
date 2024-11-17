package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import org.springframework.stereotype.Component;

@Component
public class EmployeeGrpcClient {

    private final EmployeeDataServiceGrpc.EmployeeDataServiceBlockingStub employeeStub;

    public EmployeeGrpcClient(ManagedChannel employeeChannel) {
        this.employeeStub = EmployeeDataServiceGrpc.newBlockingStub(employeeChannel);
    }

    public GetEmployeeResponse getEmployeeById(int employeeId) {
        GetEmployeeRequest request = GetEmployeeRequest.newBuilder()
                .setEmployeeId(employeeId)
                .build();
        return employeeStub.getEmployeeById(request);
    }
}
