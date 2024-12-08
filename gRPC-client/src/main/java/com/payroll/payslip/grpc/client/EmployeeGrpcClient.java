package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.CreateEmployeeRequest;
import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeGrpcClient {

    @GrpcClient("employee-server")
    private EmployeeDataServiceGrpc.EmployeeDataServiceBlockingStub employeeStub;

    public GetEmployeeResponse getEmployeeById(long employeeId) {
        GetEmployeeRequest request = GetEmployeeRequest.newBuilder()
                .setEmployeeId(employeeId)
                .build();
        return employeeStub.getEmployeeById(request);
    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        return employeeStub.createEmployeeViaPerson(request);
    }
}
