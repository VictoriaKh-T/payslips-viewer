package com.payroll.payslip.grpc.server;

import javax.annotation.PostConstruct;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.payroll.payslip.proto.CreateEmployeeRequest;
import com.payroll.payslip.proto.CreateEmployeeResponse;
import com.payroll.payslip.proto.Employee;
import com.payroll.payslip.proto.EmployeeDataServiceGrpc;
import com.payroll.payslip.proto.GetEmployeeRequest;
import com.payroll.payslip.proto.GetEmployeeResponse;
import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;

@GrpcService
public class EmployeeDataServiceImpl extends EmployeeDataServiceGrpc.EmployeeDataServiceImplBase {

  private ManagedChannel personChannel;
  private PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

  @PostConstruct
  public void init() {
    personChannel = ManagedChannelBuilder.forAddress("localhost", 50053).usePlaintext().build();
    personStub = PersonDataServiceGrpc.newBlockingStub(personChannel);
  }

  private Logger logger = LoggerFactory.getLogger(EmployeeDataServiceImpl.class);

  @Override
  public void createEmployeeViaPerson(
      CreateEmployeeRequest request, StreamObserver<CreateEmployeeResponse> responseObserver) {
    long personId = request.getPersonId();

    GetPersonRequest getPersonRequest = GetPersonRequest.newBuilder().setId(personId).build();
    logger.debug("Received request for person " + personId);

    GetPersonResponse personResponse = personStub.getPersonById(getPersonRequest);

    String firstName = personResponse.getFirstName();
    String sureName = personResponse.getSureName();
    String fullName = sureName + " " + firstName;

    logger.info("first name: " + firstName);
    logger.info("sure name: " + sureName);

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

    Employee employee = Employee.newBuilder().setId(request.getEmployeeId()).build();
    GetEmployeeResponse response = GetEmployeeResponse.newBuilder().setEmployee(employee).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }

  private int generateEmployeeId() {
    return (int) (Math.random() * 10000);
  }
}
