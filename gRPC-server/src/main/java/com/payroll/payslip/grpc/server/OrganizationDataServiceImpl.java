package com.payroll.payslip.grpc.server;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;

@GrpcService
public class OrganizationDataServiceImpl
    extends OrganizationDataServiceGrpc.OrganizationDataServiceImplBase {

  @Override
  public void getDataOrganizationById(
      GetOrganizationRequest request, StreamObserver<GetOrganizationResponse> responseObserver) {
    super.getDataOrganizationById(request, responseObserver);
  }
}
