package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetOrganizationRequest;
import com.payroll.payslip.proto.GetOrganizationResponse;
import com.payroll.payslip.proto.OrganizationDataServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class OrganizationGrpcClient {
    @GrpcClient("organization-server")
    private OrganizationDataServiceGrpc.OrganizationDataServiceBlockingStub organizationStub;

    public GetOrganizationResponse getOrganizationById(int organizationId) {
        GetOrganizationRequest request = GetOrganizationRequest.newBuilder()
                .setOrganizationId(organizationId)
                .build();
        return organizationStub.getOrganizationById(request);
    }
}
