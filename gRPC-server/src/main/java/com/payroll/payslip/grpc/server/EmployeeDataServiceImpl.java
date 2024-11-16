package com.payroll.payslip.grpc.server;

import com.payroll.payslip.proto.CreateEmployeeRequest;
import com.payroll.payslip.proto.GetPersonRequest;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;

@GrpcService
public class EmployeeDataServiceImpl extends EmployeeDataServiceGrpc.EmployeeDataServiceImplBase {

  private final ManagedChannel personChannel =
      ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
  private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub =
      PersonDataServiceGrpc.newBlockingStub(personChannel);

  @Override
  public void createEmployeeViaPerson(CreateEmployeeRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
    int personId = request.getPersonId();
    GetPersonRequest getPersonRequest = GetPersonRequest.newBuilder().setPersonId(personId).build();
    System.out.println("Received request for person " + personId);

    GetPersonResponse personResponse = personStub.getPersonById(getPersonRequest);

    String firstName = personResponse.getPerson().getFirstName();
    String sureName = personResponse.getPerson().getSureName();
    String fullName = sureName + " " + firstName;

    CreateEmployeeResponse response =
            CreateEmployeeResponse.newBuilder()
                    .setId(generateEmployeeId())
                    .setFullName(fullName)
                    .setPersonId(personId)
                    .build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  @Override
  public void getEmployeeById(
      GetEmployeeRequest request, StreamObserver<GetEmployeeResponse> responseObserver) {

  }

  private int generateEmployeeId() {
    return (int) (Math.random() * 10000);
  }
}
