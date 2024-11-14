package com.payroll.payslip.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;

@GrpcService
public class PersonDataServiceImpl extends PersonDataServiceGrpc.PersonDataServiceImplBase {

  @Override
  public void getPersonById(
      GetPersonRequest request, StreamObserver<GetPersonResponse> responseObserver) {
    super.getPersonById(request, responseObserver);
  }
}
