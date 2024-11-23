package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrganizationGrpcClient {
    private final OrganizationDataServiceGrpc.OrganizationDataServiceBlockingStub organizationStub;

    public OrganizationGrpcClient(@Qualifier("organizationChannel") ManagedChannel organizationChannel) {
        this.organizationStub = OrganizationDataServiceGrpc.newBlockingStub(organizationChannel);
    }

    public GetOrganizationResponse getOrganizationById(int organizationId) {
        GetOrganizationRequest request = GetOrganizationRequest.newBuilder()
                .setOrganizationId(organizationId)
                .build();
        return organizationStub.getOrganizationById(request);
    }
}
