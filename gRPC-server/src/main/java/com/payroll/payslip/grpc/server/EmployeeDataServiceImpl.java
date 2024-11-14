package com.payroll.payslip.grpc.server;

import com.payroll.payslip.proto.Employee;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import lombok.AllArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetPersonRequest;

@GrpcService
@AllArgsConstructor
public class EmployeeDataServiceImpl extends EmployeeDataServiceGrpc.EmployeeDataServiceImplBase {

    private final ManagedChannel personChannel = ManagedChannelBuilder.forAddress("localhost", 50053)
            .usePlaintext()
            .build();
    private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub
            = PersonDataServiceGrpc.newBlockingStub(personChannel);

  @Override
  public void createEmployeeViaPerson(
          GetPersonRequest request,
          StreamObserver<CreateEmployeeResponse> responseObserver) {

    int personId = request.getPersonId();
    System.out.println("Received request for person " + personId);

    GetPersonResponse personResponse = personStub.getPersonById(request);

    String firstName = personResponse.getPerson().getFirstName();
    String sureName = personResponse.getPerson().getSureName();
    String fullName = sureName + " " + firstName;

      CreateEmployeeResponse response = CreateEmployeeResponse.newBuilder()
              .setId(generateEmployeeId())
              .setFullName(fullName)
              .setPersonId(personId)
              .build();

      responseObserver.onNext(response);
      responseObserver.onCompleted();

 }

  @Override
  public void addEmployeeOrganizationData(
      GetOrganizationRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
    super.addEmployeeOrganizationData(request, responseObserver);
  }

  @Override
  public void getEmployeeById(
      GetEmployeeRequest request, StreamObserver<GetEmployeeResponse> responseObserver) {
    super.getEmployeeById(request, responseObserver);
  }

    private int generateEmployeeId() {
        return (int) (Math.random() * 10000);
    }
}
