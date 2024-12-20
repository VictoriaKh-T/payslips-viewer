package com.payroll.payslip.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.Person;
import com.payroll.payslip.proto.PersonDataServiceGrpc;

@GrpcService
public class PersonDataServiceImpl extends PersonDataServiceGrpc.PersonDataServiceImplBase {

  @Override
  public void getPersonById(
      GetPersonRequest request, StreamObserver<GetPersonResponse> responseObserver) {
    Person person = Person.newBuilder().setId(request.getPersonId()).build();
    GetPersonResponse response = GetPersonResponse.newBuilder().setPerson(person).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
