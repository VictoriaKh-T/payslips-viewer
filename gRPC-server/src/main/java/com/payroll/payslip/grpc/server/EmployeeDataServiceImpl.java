package com.payroll.payslip.grpc.server;

import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetPersonRequest;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class EmployeeDataServiceImpl extends EmployeeDataServiceGrpc.EmployeeDataServiceImplBase {
    @Override
    public void createEmployeeViaPerson(GetPersonRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
        super.createEmployeeViaPerson(request, responseObserver);
    }

    @Override
    public void addEmployeeOrganizationData(GetOrganizationRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
        super.addEmployeeOrganizationData(request, responseObserver);
    }

    @Override
    public void getEmployeeById(GetEmployeeRequest request, StreamObserver<GetEmployeeResponse> responseObserver) {
        super.getEmployeeById(request, responseObserver);
    }
}
