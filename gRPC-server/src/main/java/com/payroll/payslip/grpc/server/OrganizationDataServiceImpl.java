package com.payroll.payslip.grpc.server;

import com.payroll.payslip.proto.Organization;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;

@GrpcService
public class OrganizationDataServiceImpl
    extends OrganizationDataServiceGrpc.OrganizationDataServiceImplBase {

  @Override
  public void getOrganizationById(GetOrganizationRequest request, StreamObserver<GetOrganizationResponse> responseObserver) {
    GetOrganizationResponse response = GetOrganizationResponse.newBuilder().setOrganization(
            Organization.newBuilder().setOrganizationId(request.getOrganizationId()).build()).build();
    responseObserver.onNext(response);
    responseObserver.onCompleted();
  }
}
