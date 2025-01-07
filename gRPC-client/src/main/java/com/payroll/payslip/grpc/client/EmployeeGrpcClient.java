package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.CreateEmployeeRequest;
import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmployeeGrpcClient {

    private final EmployeeDataServiceGrpc.EmployeeDataServiceBlockingStub employeeStub;

    public EmployeeGrpcClient(@Qualifier("employeeChannel") ManagedChannel employeeChannel) {
        this.employeeStub = EmployeeDataServiceGrpc.newBlockingStub(employeeChannel);
    }

    public GetEmployeeResponse getEmployeeById(long employeeId) {
        GetEmployeeRequest request =
                GetEmployeeRequest.newBuilder().setEmployeeId(employeeId).build();
        return employeeStub.getEmployeeById(request);
    }

    public CreateEmployeeResponse createEmployee(CreateEmployeeRequest request) {
        return employeeStub.createEmployeeViaPerson(request);
    }
}
