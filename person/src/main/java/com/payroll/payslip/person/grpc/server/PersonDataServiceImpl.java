package com.payroll.payslip.person.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.payroll.payslip.person.model.dto.PersonResponse;
import com.payroll.payslip.person.service.PersonService;
import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;

@GrpcService
public class PersonDataServiceImpl extends PersonDataServiceGrpc.PersonDataServiceImplBase {
  private final PersonService personService;

  public PersonDataServiceImpl(PersonService personService) {
    this.personService = personService;
  }

  @Override
  public void getPersonById(
      GetPersonRequest request, StreamObserver<GetPersonResponse> responseObserver) {
    System.out.println("find person by ID " + request);
    PersonResponse personResponse = personService.findPersonById(request.getId());
    GetPersonResponse response =
        GetPersonResponse.newBuilder()
            .setId(personResponse.id())
            .setFirstName(personResponse.firstName())
            .setSureName(personResponse.surname())
            .build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
