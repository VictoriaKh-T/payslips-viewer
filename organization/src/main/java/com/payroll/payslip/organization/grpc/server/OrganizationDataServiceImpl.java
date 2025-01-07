package com.payroll.payslip.organization.grpc.server;

import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.Organization;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class OrganizationDataServiceImpl extends OrganizationDataServiceGrpc.OrganizationDataServiceImplBase {

    @Override
    public void getOrganizationById(
            GetOrganizationRequest request, StreamObserver<GetOrganizationResponse> responseObserver) {
        GetOrganizationResponse response = GetOrganizationResponse.newBuilder()
                .setOrganization(Organization.newBuilder()
                        .setOrganizationId(request.getOrganizationId())
                        .build())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
