package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Component;


@Component
public class PersonGrpcClient {

    @GrpcClient("person-server")
    private PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

    public GetPersonResponse getPersonById(long personId) {
        GetPersonRequest request = GetPersonRequest.newBuilder()
                .setId(personId)
                .build();
        return personStub.getPersonById(request);
    }
}
