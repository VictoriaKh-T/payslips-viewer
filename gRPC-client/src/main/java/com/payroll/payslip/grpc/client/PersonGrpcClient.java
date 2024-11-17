package com.payroll.payslip.grpc.client;

import com.payroll.payslip.proto.GetPersonRequest;
import com.payroll.payslip.proto.GetPersonResponse;
import com.payroll.payslip.proto.PersonDataServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class PersonGrpcClient {
    private final PersonDataServiceGrpc.PersonDataServiceBlockingStub personStub;

    public PersonGrpcClient(@Qualifier("personChannel")ManagedChannel personChannel) {
        this.personStub = PersonDataServiceGrpc.newBlockingStub(personChannel);
    }

    public GetPersonResponse getPersonById(int personId) {
        GetPersonRequest request = GetPersonRequest.newBuilder()
                .setPersonId(personId)
                .build();
        return personStub.getPersonById(request);
    }
}
